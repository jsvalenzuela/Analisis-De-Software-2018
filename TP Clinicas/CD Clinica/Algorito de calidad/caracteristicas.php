<?php
require_once('utils/main.php');
require 'utils/Caracteristica.php';
require 'utils/Aspecto.php';
require 'utils/Valor.php';

if ( ! session_id() ) @ session_start();

$id_caracteristica = isset($_POST['id_next']) ? $_POST['id_next'] : 0;

if($_SERVER['REQUEST_METHOD']=='POST'){
    /**
     * Procesar request
     */
    $c = new Caracteristica($_POST['id']);
    $puntos_categorias = 0;

    $idAspectos = $c->getIdAspectos();
    foreach($idAspectos as $id_aspecto) {

        $a = New Aspecto($id_aspecto);

        $valores_marcados = 0;
        $idValores = $a->getIdValores();
        foreach ($idValores as $id_valor) {
            $v = new Valor($id_valor);
            if($_POST['valor_' . $id_valor]){
                $valores_marcados++;

            }
        }
        $puntos_categorias += $valores_marcados/count($idValores);


    }
    $_SESSION['caracteristicas'][$c->id] = array(
        'puntas_alcanzar'=>(count($idAspectos)*$c->ponderacion),
        'puntos_alcanzados'=>($puntos_categorias*$c->ponderacion)
    );
    $_SESSION['total_acumulado'] += ($puntos_categorias*$c->ponderacion);

    #echo "puntos categorias: " . $puntos_categorias;

    if(!$c->siguiente){
        header('Location:resumen.php');
        exit();
    }

}else{
    session_destroy();
    $_SESSION['total_aspectos'] = 0;
    $_SESSION['total_acumulado'] = 0;
}
$nroaspectos = 0;
$c = New Caracteristica($id_caracteristica);

$aspectos = "";
foreach($c->getIdAspectos() as $id_aspecto) {
    $nroaspectos+=1;
    $a = New Aspecto($id_aspecto);
    $aspectos .= "<H2>". $a->nombre ."</H2>";
    $aspectos .= "<ul>";
    foreach ($a->getIdValores() as $id_valor) {
        $v = new Valor($id_valor);
        $aspectos .= "<li><input type='checkbox' name='valor_$id_valor' id='valor_$id_valor' value='1'>" .  $v->nombre  . "</li>";
    }
    $aspectos .= "</ul>";
}

$tpl_caracteristica = file_get_contents('html/caracteristica.html');
$tpl_caracteristica = str_replace(array(
                                        '{{id_caracteristica}}',
                                        '{{siguiente_caracteristica}}',
                                        '{{caracteristica}}',
                                        '{{aspectos}}'),
                                  array(
                                      $c->id,
                                      $c->siguiente,
                                      $c->nombre,
                                      $aspectos),
                                  $tpl_caracteristica
    );


$tpl_main = file_get_contents('html/main.html');
$tpl_main = str_replace('{{body_content}}', $tpl_caracteristica, $tpl_main);

echo $tpl_main;

$_SESSION['total_aspectos'] = $_SESSION['total_aspectos'] + ($nroaspectos*$c->ponderacion);

?>
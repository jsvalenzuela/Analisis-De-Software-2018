<?php
require_once('utils/main.php');
require 'utils/Caracteristica.php';
require 'utils/Aspecto.php';
require 'utils/Valor.php';

$id = $_GET['id'];
$c = new Caracteristica($id);

if($_SERVER['REQUEST_METHOD']=='POST'){
    $c->nombre = $_POST['nombre'];
    $c->ponderacion = $_POST['ponderacion'];
    $c->save();
    header("Location: caracteristicas_listado.php");
}


$body = "<h1>Editar Caracteristica</h1>";

$form = file_get_contents('html/caracteristicas_editar/form.html');



$body .= $form = str_replace(array(
    '{{id}}',
    '{{nombre}}',
    '{{ponderacion}}'),
    array(
        $c->id,
        $c->nombre,
        $c->ponderacion),
    $form
);

$body .= "<h2>Listado de aspectos</h2>";

$body .= file_get_contents('html/listado_aspectos/header.html');

$aspectos = $c->getAspectos();

foreach ($aspectos as $k=>$v){
    $a = new Aspecto($v['id']);
    $linea = file_get_contents('html/listado_aspectos/linea.html');
    $linea = str_replace(
        array(
            '{{id}}',
            '{{nombre}}'
        ),
        array(
            $a->id,
            $a->nombre
        ),
        $linea
    );
    $body .= $linea;

}

$body .= file_get_contents('html/listado_aspectos/footer.html');




$tpl_main = file_get_contents('html/main.html');
$tpl_main = str_replace('{{body_content}}', $body, $tpl_main);

echo $tpl_main;

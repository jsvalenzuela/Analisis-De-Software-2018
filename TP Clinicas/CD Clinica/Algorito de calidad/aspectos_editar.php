<?php
require_once('utils/main.php');
require 'utils/Caracteristica.php';
require 'utils/Aspecto.php';
require 'utils/Valor.php';

$id = $_GET['id'];
$a = new Aspecto($id);

if($_SERVER['REQUEST_METHOD']=='POST'){
    $a->nombre = $_POST['nombre'];
    $a->save();
    header("Location: caracteristicas_editar.php?id=" . $a->id_caracteristica);
}


$body = "<h1>Editar Aspecto</h1>";

$form = file_get_contents('html/aspectos_editar/form.html');



$body .= $form = str_replace(
    array(
        '{{id}}',
        '{{nombre}}',
    ),
    array(
        $a->id,
        $a->nombre,
    ),
    $form
);

$body .= "<h2>Listado de valores</h2>";

$body .= file_get_contents('html/listado_valores/header.html');

$valores = $a->getIdValores();

foreach ($valores as $k=>$v){
    $valor = new Valor($v['id']);
    $linea = file_get_contents('html/listado_valores/linea.html');
    $linea = str_replace(
        array(
            '{{id}}',
            '{{nombre}}',
            '{{nulo}}',
        ),
        array(
            $valor->id,
            $valor->nombre,
            $valor->nulo,
        ),
        $linea
    );
    $body .= $linea;

}

$body .= file_get_contents('html/listado_valores/footer.html');

$tpl_main = file_get_contents('html/main.html');
$tpl_main = str_replace('{{body_content}}', $body, $tpl_main);

echo $tpl_main;

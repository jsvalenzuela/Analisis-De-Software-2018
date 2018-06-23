<?php
require_once('utils/main.php');
require 'utils/Caracteristica.php';

$caracteristicas = Caracteristica::GetAll();

$body = "<h1>Caracteristicas</h1>";


$body .= file_get_contents('html/listado_caracteristicas/header.html');


foreach ($caracteristicas as $k=>$v){
    $c = new Caracteristica($v['id']);
    $linea_caracteristica = file_get_contents('html/listado_caracteristicas/linea.html');
    $linea_caracteristica = str_replace(array(
        '{{id}}',
        '{{nombre}}',
        '{{ponderacion}}'),
        array(
            $c->id,
            $c->nombre,
            $c->ponderacion),
        $linea_caracteristica
    );
    $body .= $linea_caracteristica;

}

$body .= file_get_contents('html/listado_caracteristicas/footer.html');



$tpl_main = file_get_contents('html/main.html');
$tpl_main = str_replace('{{body_content}}', $body, $tpl_main);

#echo $body;
echo $tpl_main;

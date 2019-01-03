<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Ejemplo.xsl
    Created on : 5 de diciembre de 2018, 19:32
    Author     : cainu
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <!-- tipo de archivo que va a generar en este caso html -->
    <xsl:output method="html"/>
    <!-- plantilla que sustituye el texto por todo, gracias al nodo raiz / -->
    <xsl:template match="/">
   Si anadimos lo siguiente etiqueta, imprimira la plantilla siguiente. 
        Sino, esta sustituria todo.
        <xsl:apply-templates/>
        
    </xsl:template> 
    
    <xsl:template match="Destinatario">
   Este texto sustituye al destinatario y muestra el email:
    - <xsl:value-of select="Mail"/>
    Si buscasemos un atributo y no un texto se tendria que escrbir en el
    select: 'Mail/@nombredelatributo'.
    </xsl:template>

</xsl:stylesheet>

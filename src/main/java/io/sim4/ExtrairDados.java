package io.sim4;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* 

public class ExtrairDados {

    public static Map<String, String> lerArquivo(String caminhoArquivo) throws Exception {
        // Cria um objeto DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Cria um objeto DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Carrega o arquivo XML
        Document document = builder.parse(new File());

        // Cria um mapa para armazenar os dados extraídos
        Map<String, String> dados = new HashMap<>();

        // Percorre o documento XML
        NodeList nodes = document.getElementsByTagName("vehicle");
        for (int i = 0; i < nodes.getLength(); i++) {
            // Obtém o nó atual
            Node node = nodes.item(i);

            // Obtém o valor do atributo "id"
            String id = node.getAttributes().getNamedItem("id").getNodeValue();

            // Obtém o valor do elemento "nome"
            String nome = node.getElementsByTagName("depart").item(0).getTextContent();

            // Obtém o valor do elemento "preco"
            String preco = node.getElementsByTagName("preco").item(0).getTextContent();

            // Adiciona os dados ao mapa
            dados.put(id, nome + " - " + preco);
        }

        // Retorna os dados
        return dados;
    }

}*/


package com.exemplo.caderno;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.FileOutputStream;
import java.io.IOException;

public class GerarCaderno {

    public static void main(String[] args) {
        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFParagraph p1 = doc.createParagraph();
            p1.createRun().setText("CENTRO UNIVERSITÁRIO INTERNACIONAL UNINTER");
            XWPFParagraph p2 = doc.createParagraph();
            p2.createRun().setText("ESCOLA SUPERIOR POLITÉCNICA");
            XWPFParagraph p3 = doc.createParagraph();
            p3.createRun().setText("CURSO: Desenvolvimento Web Back End");
            doc.createParagraph().createRun().setText("\n");

            doc.createParagraph().createRun().setText("ATIVIDADE PRÁTICA\nCADERNO DE EXERCICIOS E RESPOSTAS");
            doc.createParagraph().createRun().setText("\n");
            doc.createParagraph().createRun().setText("NOME ALUNO – RU: 1234567");
            doc.createParagraph().createRun().setText("SUA CIDADE – SEU ESTADO");
            doc.createParagraph().createRun().setText("2025\n");

            XWPFParagraph link = doc.createParagraph();
            link.createRun().setText("Link do projeto no GitHub ou similar:");
            XWPFParagraph link2 = doc.createParagraph();
            link2.createRun().setText("[Coloque aqui o link do seu repositório]");

            XWPFParagraph t1 = doc.createParagraph();
            t1.createRun().setText("Teste 1 – Inserir novas tarefas e verificar se aparecem na lista");
            XWPFParagraph t1det = doc.createParagraph();
            t1det.createRun().setText(
                    "Tarefa especial (obrigatória para o teste):\n" +
                    "- Nome: Desenvolvimento da API\n" +
                    "- Responsável: Roberto – RU 1234567\n" +
                    "- Data de entrega: 12/12/2025"
            );
            XWPFParagraph t1endpoint = doc.createParagraph();
            t1endpoint.createRun().setText("Endpoint utilizado: POST /tarefas");
            XWPFParagraph t1json = doc.createParagraph();
            t1json.createRun().setText("{\n" +
                    "  \"nome\": \"Desenvolvimento da API\",\n" +
                    "  \"dataEntrega\": \"2025-12-12\",\n" +
                    "  \"responsavel\": \"Roberto - RU 1234567\"\n" +
                    "}");
            XWPFParagraph t1print = doc.createParagraph();
            t1print.createRun().setText("(inserir aqui print do Postman)");

            XWPFParagraph t2 = doc.createParagraph();
            t2.createRun().setText("Teste 2 – Listar todas as tarefas cadastradas");
            XWPFParagraph t2endpoint = doc.createParagraph();
            t2endpoint.createRun().setText("Endpoint utilizado: GET /tarefas");
            XWPFParagraph t2print = doc.createParagraph();
            t2print.createRun().setText("(inserir aqui print do Postman mostrando o registro com seu nome + RU)");

            XWPFParagraph t3 = doc.createParagraph();
            t3.createRun().setText("Teste 3 – Atualizar o cadastro (com seu nome) e verificar se os dados estão refletidos corretamente");
            XWPFParagraph t3endpoint = doc.createParagraph();
            t3endpoint.createRun().setText("Endpoint utilizado: PUT /tarefas/{id}");
            XWPFParagraph t3json = doc.createParagraph();
            t3json.createRun().setText("{\n" +
                    "  \"nome\": \"Desenvolvimento da API - Atualizado\",\n" +
                    "  \"dataEntrega\": \"2025-12-15\",\n" +
                    "  \"responsavel\": \"Roberto - RU 1234567\"\n" +
                    "}");
            XWPFParagraph t3print = doc.createParagraph();
            t3print.createRun().setText("(inserir aqui print do Postman mostrando que a tarefa foi atualizada)");

            XWPFParagraph t4 = doc.createParagraph();
            t4.createRun().setText("Teste 4 – Excluir um cadastro (com seu nome) e mostrar que ele desaparece da lista");
            XWPFParagraph t4endpoint = doc.createParagraph();
            t4endpoint.createRun().setText("Endpoint utilizado: DELETE /tarefas/{id}");
            XWPFParagraph t4print = doc.createParagraph();
            t4print.createRun().setText("(inserir aqui print do Postman mostrando que o registro sumiu da lista)");

            try (FileOutputStream out = new FileOutputStream("Caderno_Exercicios_API_Tarefas.docx")) {
                doc.write(out);
                System.out.println("Caderno gerado com sucesso!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

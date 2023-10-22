
package io.sim3;

import org.apache.poi.ss.usermodel.*;//Tirado do GPT
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.python.modules.thread.thread;

import java.io.FileOutputStream;
import java.io.IOException;

public class GeraRelatorio extends Thread{
    //public static void main(String[] args) {
    private String autoID;
    private Long timeStamp;
    private Double speed;
    private Double fuelConsumption;
    private Double co2Emission;
    private Double x_Position;
    private Double y_Position;
    private int fuelType;

    //private Double m7;
    //private Double m8;
    
    



    GeraRelatorio(String autoId,Long timeStamp,Double speed,Double fuelConsumption,Double co2Emission,Double x_Position,Double y_Position,int fuelType){//String m
        this.timeStamp=timeStamp;
        this.autoID=autoID;
        this.fuelConsumption=fuelConsumption;
        this.speed=speed;
        this.co2Emission=co2Emission;
        this.x_Position=x_Position;
        this.y_Position=y_Position;
        this.fuelType=fuelType;

    }
    //public void gerarRelatorio(){
    public void run(){
        //public void gerarRelatorio(){
        System.out.println("mnmnmn");
        Workbook workbook = new XSSFWorkbook();

        // Crie uma nova planilha
        Sheet sheet = workbook.createSheet("MinhaPlanilha");

        // Crie uma linha
        Row row = sheet.createRow(0);

        // Crie uma célula e insira dados nela
        Cell cell = row.createCell(0);
        cell.setCellValue("Timestamp");

        // Crie outra célula e insira dados nela
        cell = row.createCell(1);
        cell.setCellValue("Id Car");

        // Crie outra célula e insira dados nela
        cell = row.createCell(2);
        cell.setCellValue("ID Route");

        // Crie outra célula e insira dados nela
        cell = row.createCell(3);
        cell.setCellValue("Speed");

        // Crie outra célula e insira dados nela
        cell = row.createCell(4);
        cell.setCellValue("Distance");

        // Crie outra célula e insira dados nela
        cell = row.createCell(5);
        cell.setCellValue("FuelConsuption");

        // Crie outra célula e insira dados nela
        cell = row.createCell(6);
        cell.setCellValue("FuelType");

        // Crie outra célula e insira dados nela
        cell = row.createCell(7);
        cell.setCellValue("CO2Emission");

        // Crie outra célula e insira dados nela
        cell = row.createCell(8);
        cell.setCellValue("Longitude");

        // Crie outra célula e insira dados nela
        cell = row.createCell(9);
        cell.setCellValue("Latitude");

        // Crie uma nova linha
        //int i=0;
        //while(true){
        for(int i = 1;i<999;i++){
            row = sheet.createRow(1);//antes era i

            // Insira dados na segunda linha
            cell = row.createCell(0);
            cell.setCellValue(timeStamp);//trazer os dados do carro para cá

            cell = row.createCell(1);
            cell.setCellValue(autoID);

            cell = row.createCell(2);
            cell.setCellValue("null");
            
            cell = row.createCell(3);
            cell.setCellValue(speed);

            cell = row.createCell(4);
            cell.setCellValue("null");

            cell = row.createCell(5);
            cell.setCellValue(fuelConsumption);

            cell = row.createCell(6);
            cell.setCellValue(fuelType);

            cell = row.createCell(7);
            cell.setCellValue(co2Emission);

            cell = row.createCell(8);
            cell.setCellValue(x_Position);

            cell = row.createCell(9);
            cell.setCellValue(y_Position);
            
        }
        

        

        
        // Crie um novo livro do Excel
        
            
            
            
            // Salve o arquivo do Excel
            try (FileOutputStream outputStream = new FileOutputStream("Exemplo1071.xlsx")) {//O gráfico 13 deu certo!!!
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
         
            System.out.println("Dados gravados com sucesso no arquivo Excel.");
    }
    //@Override
    //public void run(){
        
    //}
    /*public static void main(String[] args) {
    //public void gerarRelatorio(){
        Workbook workbook = new XSSFWorkbook();

        // Crie uma nova planilha
        Sheet sheet = workbook.createSheet("MinhaPlanilha");

        // Crie uma linha
        Row row = sheet.createRow(0);

        // Crie uma célula e insira dados nela
        Cell cell = row.createCell(0);
        cell.setCellValue("Timestamp");

        // Crie outra célula e insira dados nela
        cell = row.createCell(1);
        cell.setCellValue("Id Car");

        // Crie outra célula e insira dados nela
        cell = row.createCell(2);
        cell.setCellValue("ID Route");

        // Crie outra célula e insira dados nela
        cell = row.createCell(3);
        cell.setCellValue("Speed");

        // Crie outra célula e insira dados nela
        cell = row.createCell(4);
        cell.setCellValue("Distance");

        // Crie outra célula e insira dados nela
        cell = row.createCell(5);
        cell.setCellValue("FuelConsuption");

        // Crie outra célula e insira dados nela
        cell = row.createCell(6);
        cell.setCellValue("FuelType");

        // Crie outra célula e insira dados nela
        cell = row.createCell(7);
        cell.setCellValue("CO2Emission");

        // Crie outra célula e insira dados nela
        cell = row.createCell(8);
        cell.setCellValue("Longitude");

        // Crie outra célula e insira dados nela
        cell = row.createCell(9);
        cell.setCellValue("Latitude");

        // Crie uma nova linha
        for(int i = 1;i<10;i++){
            row = sheet.createRow(i);

            // Insira dados na segunda linha
            cell = row.createCell(0);
            cell.setCellValue("nnnn");

            cell = row.createCell(1);
            cell.setCellValue(30);

            cell = row.createCell(2);
            cell.setCellValue(30);
            
            cell = row.createCell(3);
            cell.setCellValue(30);

            cell = row.createCell(4);
            cell.setCellValue(30);

            cell = row.createCell(5);
            cell.setCellValue(30);

            cell = row.createCell(6);
            cell.setCellValue(30);

            cell = row.createCell(7);
            cell.setCellValue(30);

            cell = row.createCell(8);
            cell.setCellValue(30);

            cell = row.createCell(9);
            cell.setCellValue(30);
        }
        

        

        
        // Crie um novo livro do Excel
        for(int i=0;i<10;i++){   
            
            
            
            // Salve o arquivo do Excel
            try (FileOutputStream outputStream = new FileOutputStream("Exemplo13.xlsx")) {//O gráfico 13 deu certo!!!
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
         } 
            System.out.println("Dados gravados com sucesso no arquivo Excel.");
       
    }*/
    
}

/* 
/////////////////////copia de segurança
import org.apache.poi.ss.usermodel.*;//Tirado do GPT
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class GerenciadorCheques {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();

        // Crie uma nova planilha
        Sheet sheet = workbook.createSheet("MinhaPlanilha");

        // Crie uma linha
        Row row = sheet.createRow(0);

        // Crie uma célula e insira dados nela
        Cell cell = row.createCell(0);
        cell.setCellValue("Nome");

        // Crie outra célula e insira dados nela
        cell = row.createCell(1);
        cell.setCellValue("Idade");

        // Crie uma nova linha
        row = sheet.createRow(1);

        // Insira dados na segunda linha
        cell = row.createCell(0);
        cell.setCellValue("João");

        cell = row.createCell(1);
        cell.setCellValue(30);

        

        
        // Crie um novo livro do Excel
        for(int i=0;i<10;i++){   
            
            
            
            // Salve o arquivo do Excel
            try (FileOutputStream outputStream = new FileOutputStream("Exemplo7.xlsx")) {
                workbook.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
         } 
            System.out.println("Dados gravados com sucesso no arquivo Excel.");
       
    }
}
/////////////////////

import java.util.ArrayList;
import java.util.List;

import lombok.Cleanup;
import org.apache.commons.collections4.Iteratorutils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;



import lombok.Cleanup;

public class GerenciadorCheques{
    public List<Cheque> criar() throws IOException {
        List<Cheque> cheques = new ArrayList<>();

        @Cleanup
        FileInputStream file = new FileInputStream("arq");
        Workbook workbook = new HSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);

        List<Row> rows = (List<Row>) toList(sheet.iterator());

        rows.remove(0);

        rows.forEach(row->{
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());
            Cheque cheque = Cheque.builser()
            .data(cells.get(0).getDateCellValue())
            .numeroCheque((int) cells.get(1).getNumericCellValue())
            .nome(cells.get(2).getStringCellValue())
            .valor(new BigDecimal(cells.get(3).getNumericCelValue()))
            .status(cells.get(4).getStringCellValue())
            .qtdadeParcelas(int) cells.get(5).getNuemricCellValue())
            .formulaTotal(cells.get(6).getCellFormula())
            .build();

            cheques.add(cheque);


        });

        return cheques;
    }
    public List<?> toList(Iterator<?> iterator){
        return Iteratorutils.toList(iterator);
    }
    public void imprimir(List<Cheque> cheques){
        cheques.forEach(System.out::println);
    }
}

//Tirado do GPT

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class GerenciadorCheques {
    //public static void main(String[] args) {
        GerenciadorCheques(){
        
        }
        
    //}
    public void Arq (){
         // Caminho do arquivo Excel
        String nomeDoArquivo = "arq.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            // Cria uma nova planilha no arquivo
            Sheet sheet = workbook.createSheet("MinhaPlanilha");

            // Cria uma linha na planilha
            Row row = sheet.createRow(0);

            // Cria uma célula na linha e insere um valor
            Cell cell = row.createCell(0);
            cell.setCellValue("Olá, Excel!");

            // Salva o arquivo Excel
            try (FileOutputStream fos = new FileOutputStream(nomeDoArquivo)) {
                workbook.write(fos);
                System.out.println("Dados inseridos com sucesso no Excel.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
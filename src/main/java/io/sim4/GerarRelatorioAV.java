package io.sim4;


import org.apache.poi.ss.usermodel.*;//Tirado do GPT
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.python.modules.thread.thread;

import java.io.FileOutputStream;
import java.io.IOException;

public class GerarRelatorioAV extends Thread{
    //public static void main(String[] args) {
    private String autoID;
    private double timeStamp;
    private double speed;
    private double fuelConsumption;
    private double co2Emission;
    private double x_Position;
    private double y_Position;
    private int fuelType;
    private String routeIDSUMO;

    //private Double m7;
    //private Double m8;

    private double tempoInicial;
	private double tempoFinal;
	private double velocidadeInicial;
	private double velocidadeFinal;

	private double velocidadeP1;
	private double velocidadeP2;
	private double velocidadeP3;
	private double velocidadeP4;
	private double velocidadeP5;
	private double velocidadeP6;

	private double tempoP1;
	private double tempoP2;
	private double tempoP3;
	private double tempoP4;
	private double tempoP5;
	private double tempoP6;
    
    



    //GerarRelatorioAV(String autoId,Long timeStamp,Double speed,Double fuelConsumption,Double co2Emission,Double x_Position,Double y_Position,int fuelType){//String m
    GerarRelatorioAV(double timeStamp,String autoID,String routeIDSUMO,double speed,double fuelConsumption,int fuelType,double co2Emission,double x_Position,double y_Position, double tempoInicial,double tempoFinal,double velocidadeInicial,double velocidadeFinal,double velocidadeP1, double velocidadeP2, double velocidadeP3, double velocidadeP4, double velocidadeP5, double velocidadeP6, double tempoP1,double tempoP2, double tempoP3, double tempoP4, double tempoP5, double tempoP6){

        GerarRelatorioAV relatorio = new GerarRelatorioAV(timeStamp,autoID,routeIDSUMO,speed,fuelConsumption,fuelType,co2Emission,x_Position,y_Position, tempoInicial,tempoFinal,velocidadeInicial,velocidadeFinal, velocidadeP1,  velocidadeP2,  velocidadeP3,  velocidadeP4,  velocidadeP5,  velocidadeP6,  tempoP1, tempoP2,  tempoP3,  tempoP4,  tempoP5,  tempoP6);

        

        

        this.tempoInicial=tempoInicial;
        this.tempoFinal=tempoFinal;
        this.velocidadeInicial=velocidadeInicial;
        this.velocidadeFinal=velocidadeFinal;

        this.velocidadeP1=velocidadeP1;
        this.velocidadeP2=velocidadeP2;
        this.velocidadeP3=velocidadeP3;
        this.velocidadeP4=velocidadeP4;
        this.velocidadeP5=velocidadeP5;
        this.velocidadeP6=velocidadeP6;

        this.tempoP1=tempoP1;
        this.tempoP2=tempoP2;
        this.tempoP3=tempoP3;
        this.tempoP4=tempoP4;
        this.tempoP5=tempoP5;
        this.tempoP6=tempoP6;

        this.timeStamp=timeStamp;
        this.autoID=autoID;
        //this.routeIDSUMO=routeIDSUMO;
        this.speed=speed;
        this.fuelConsumption=fuelConsumption;
        this.fuelType=fuelType;
        this.co2Emission=co2Emission;
        this.x_Position=x_Position;
        this.y_Position=y_Position;
        this.routeIDSUMO=routeIDSUMO;

        


        

        


        
        
        /*this.timeStamp=timeStamp;
        this.autoID=autoID;
        this.fuelConsumption=fuelConsumption;
        this.speed=speed;
        this.co2Emission=co2Emission;
        this.x_Position=x_Position;
        this.y_Position=y_Position;
        this.fuelType=fuelType;*/

    }
    //public void gerarRelatorio(){
    public void run(){
        //public void gerarRelatorio(){
        System.out.println("mnmnmn");
        Workbook workbook = new XSSFWorkbook();

        // Crie uma nova planilha
        Sheet sheet = workbook.createSheet("MinhaPlanilha");

        // Crie uma linha
        Row row = sheet.createRow(1);

        // Crie uma célula e insira dados nela
        Cell cell = row.createCell(1);
        cell.setCellValue("Timestamp");

        // Crie outra célula e insira dados nela
        cell = row.createCell(2);
        cell.setCellValue("Id Car");

        // Crie outra célula e insira dados nela
        cell = row.createCell(3);
        cell.setCellValue("ID Route");

        // Crie outra célula e insira dados nela
        cell = row.createCell(4);
        cell.setCellValue("Speed");

        // Crie outra célula e insira dados nela
        //cell = row.createCell(5);
        //cell.setCellValue("Distance");

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
        cell.setCellValue("x_position");

        // Crie outra célula e insira dados nela
        cell = row.createCell(9);
        cell.setCellValue("y_position");

        // Crie outra célula e insira dados nela
        cell = row.createCell(10);
        cell.setCellValue("Tempo Inicial");

        // Crie outra célula e insira dados nela
        cell = row.createCell(11);
        cell.setCellValue("Tempo Final");

        // Crie outra célula e insira dados nela
        cell = row.createCell(12);
        cell.setCellValue("Velociade Inicial");

        // Crie outra célula e insira dados nela
        cell = row.createCell(13);
        cell.setCellValue("Velociade Final");

        // Crie outra célula e insira dados nela
        cell = row.createCell(14);
        cell.setCellValue("Velociade P1");

        // Crie outra célula e insira dados nela
        cell = row.createCell(15);
        cell.setCellValue("Velociade P2");

        // Crie outra célula e insira dados nela
        cell = row.createCell(16);
        cell.setCellValue("Velociade P3");

        // Crie outra célula e insira dados nela
        cell = row.createCell(17);
        cell.setCellValue("Velociade P4");

        // Crie outra célula e insira dados nela
        cell = row.createCell(18);
        cell.setCellValue("Velociade P5");

        // Crie outra célula e insira dados nela
        cell = row.createCell(19);
        cell.setCellValue("Velociade P6");

        // Crie outra célula e insira dados nela
        cell = row.createCell(20);
        cell.setCellValue("Tempo P1");

         // Crie outra célula e insira dados nela
        cell = row.createCell(21);
        cell.setCellValue("Tempo P2");

         // Crie outra célula e insira dados nela
        cell = row.createCell(22);
        cell.setCellValue("Tempo P3");

         // Crie outra célula e insira dados nela
        cell = row.createCell(23);
        cell.setCellValue("Tempo P4");

         // Crie outra célula e insira dados nela
        cell = row.createCell(24);
        cell.setCellValue("Tempo P5");

         // Crie outra célula e insira dados nela
        cell = row.createCell(25);
        cell.setCellValue("Tempo P6");

        // Crie uma nova linha
        //int i=0;
        //while(true){
        for(int i = 2;i<100;i++){//antes era até 999
            row = sheet.createRow(i);//antes era i

            // Insira dados na segunda linha
            cell = row.createCell(1);
            cell.setCellValue(timeStamp);//trazer os dados do carro para cá

            cell = row.createCell(2);
            cell.setCellValue(autoID);

            cell = row.createCell(3);
            cell.setCellValue(routeIDSUMO);
            
            cell = row.createCell(4);
            cell.setCellValue(speed);

            //cell = row.createCell(5);
            //cell.setCellValue(1599);

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

            cell = row.createCell(10);
            cell.setCellValue(tempoInicial);

            cell = row.createCell(11);
            cell.setCellValue(tempoFinal);

            cell = row.createCell(12);
            cell.setCellValue(velocidadeInicial);

            cell = row.createCell(13);
            cell.setCellValue(velocidadeFinal);

            cell = row.createCell(14);
            cell.setCellValue(velocidadeP1);

            cell = row.createCell(15);
            cell.setCellValue(velocidadeP2);

            cell = row.createCell(16);
            cell.setCellValue(velocidadeP3);

            cell = row.createCell(17);
            cell.setCellValue(velocidadeP4);

            cell = row.createCell(18);
            cell.setCellValue(velocidadeP5);

            cell = row.createCell(19);
            cell.setCellValue(velocidadeP6);

            cell = row.createCell(20);
            cell.setCellValue(tempoP1);

            cell = row.createCell(21);
            cell.setCellValue(tempoP2);

            cell = row.createCell(22);
            cell.setCellValue(tempoP3);

            cell = row.createCell(23);
            cell.setCellValue(tempoP4);

            cell = row.createCell(24);
            cell.setCellValue(tempoP5);

            cell = row.createCell(25);
            cell.setCellValue(tempoP6);
            
        }
        

        

        
        // Crie um novo livro do Excel
        
            
            
            
            // Salve o arquivo do Excel
            try (FileOutputStream outputStream = new FileOutputStream("Exemplo1.xlsx")) {//O gráfico 13 deu certo!!!
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

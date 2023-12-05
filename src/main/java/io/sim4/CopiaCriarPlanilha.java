package io.sim4;

/*package io.sim4;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CriarPlanilhaExcel {

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

    public void createSheet(String nome) {
        String nomeDoArquivo = "exemplo1.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(nome);

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Timestamp");
            headerRow.createCell(1).setCellValue("ID Car");
            headerRow.createCell(2).setCellValue("ID Route");
            headerRow.createCell(3).setCellValue("Speed");
            headerRow.createCell(4).setCellValue("Distance");
            headerRow.createCell(5).setCellValue("FuelConsumption");
            headerRow.createCell(6).setCellValue("FuelType");
            headerRow.createCell(7).setCellValue("CO2Emission");
            headerRow.createCell(8).setCellValue("posição X");
            headerRow.createCell(9).setCellValue("posição Y");

            headerRow.createCell(10).setCellValue("velocidadeP1");
            headerRow.createCell(11).setCellValue("velocidadeP2");
            headerRow.createCell(12).setCellValue("velocidadeP3");
            headerRow.createCell(13).setCellValue("velocidadeP4");
            headerRow.createCell(14).setCellValue("velocidadeP1");
            headerRow.createCell(15).setCellValue("velocidadeP2");
            headerRow.createCell(16).setCellValue("velocidadeP3");
            headerRow.createCell(17).setCellValue("velocidadeP4");
            headerRow.createCell(18).setCellValue("velocidadeP5");
            headerRow.createCell(19).setCellValue("velocidadeP6");
            headerRow.createCell(20).setCellValue("tempoP1");
            headerRow.createCell(21).setCellValue("tempoP2");
             headerRow.createCell(22).setCellValue("tempoP3");
              headerRow.createCell(23).setCellValue("tempoP4");
             headerRow.createCell(24).setCellValue("tempoP5");
              headerRow.createCell(25).setCellValue("tempoP6");
            // Salva o arquivo .xlsx após criar todas as abas de planilha.
            try (FileOutputStream outputStream = new FileOutputStream(nomeDoArquivo)) {
                workbook.write(outputStream);
                //System.out.println("Planilha criada com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSheetCar(double timeStamp,String autoID,String routeIDSUMO,double speed,double fuelConsumption,int fuelType,double co2Emission,double x_Position,double y_Position, double tempoInicial,double tempoFinal,double velocidadeInicial,double velocidadeFinal,double velocidadeP1, double velocidadeP2, double velocidadeP3, double velocidadeP4, double velocidadeP5, double velocidadeP6, double tempoP1,double tempoP2, double tempoP3, double tempoP4, double tempoP5, double tempoP6, String nomeDoArquivo, String nomeDaAba) {//DrivingData data

        try (FileInputStream inputStream = new FileInputStream(nomeDoArquivo);
            Workbook workbook = WorkbookFactory.create(inputStream);
            FileOutputStream outputStream = new FileOutputStream(nomeDoArquivo)) {

            Sheet sheet = workbook.getSheet(nomeDaAba);

            int lastRowNum = sheet.getLastRowNum();
            Row newRow = sheet.createRow(lastRowNum + 1);

            // Preencha as células da nova linha com os dados da classe TransferData

            

            newRow.createCell(0).setCellValue(timeStamp);
            newRow.createCell(1).setCellValue(autoID); //Pegar o ID do carro
            newRow.createCell(2).setCellValue(routeIDSUMO);
            newRow.createCell(3).setCellValue(speed);
            newRow.createCell(4).setCellValue(fuelConsumption);
            newRow.createCell(5).setCellValue(fuelType);
            newRow.createCell(6).setCellValue(co2Emission);
            newRow.createCell(7).setCellValue(x_Position);
            newRow.createCell(8).setCellValue(y_Position); // Corrigido para pegar a posição X
            newRow.createCell(9).setCellValue(tempoInicial); // Corrigido para pegar a posição Y
             newRow.createCell(10).setCellValue(tempoFinal); // Corrigido para pegar a posição Y
             newRow.createCell(11).setCellValue(velocidadeInicial); // Corrigido para pegar a posição Y
             newRow.createCell(12).setCellValue(velocidadeFinal); // Corrigido para pegar a posição Y
             
             newRow.createCell(13).setCellValue(velocidadeFinal); // Corrigido para pegar a posição Y
            
            newRow.createCell(14).setCellValue(velocidadeP1); // Corrigido para pegar a posição Y
            newRow.createCell(15).setCellValue(velocidadeP2); // Corrigido para pegar a posição Y
            newRow.createCell(16).setCellValue(velocidadeP3); // Corrigido para pegar a posição Y
            newRow.createCell(17).setCellValue(velocidadeP4); // Corrigido para pegar a posição Y
             newRow.createCell(18).setCellValue(velocidadeP5); // Corrigido para pegar a posição Y
              newRow.createCell(19).setCellValue(velocidadeP6); // Corrigido para pegar a posição Y
             newRow.createCell(20).setCellValue(tempoP1); // Corrigido para pegar a posição Y
              newRow.createCell(21).setCellValue(tempoP2); // Corrigido para pegar a posição Y
             newRow.createCell(22).setCellValue(tempoP3); // Corrigido para pegar a posição Y
             newRow.createCell(23).setCellValue(tempoP4); // Corrigido para pegar a posição Y
             newRow.createCell(24).setCellValue(tempoP5); // Corrigido para pegar a posição Y
             newRow.createCell(25).setCellValue(tempoP6); // Corrigido para pegar a posição Y
            
            
            
            
            
            
            


            // Salve as alterações na planilha
            workbook.write(outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void adicionarAba(String nomeDoArquivo, String nomeDaAba) {
        try (FileInputStream inputStream = new FileInputStream(nomeDoArquivo);
            Workbook workbook = WorkbookFactory.create(inputStream);
            FileOutputStream outputStream = new FileOutputStream(nomeDoArquivo)) {

            // Cria uma nova aba na planilha existente
            Sheet newSheet = workbook.createSheet(nomeDaAba);

            // Adiciona o cabeçalho à nova aba
            Row headerRow = newSheet.createRow(0);
            headerRow.createCell(0).setCellValue("Timestamp");
            headerRow.createCell(1).setCellValue("ID Car");
            headerRow.createCell(2).setCellValue("ID Route");
            headerRow.createCell(3).setCellValue("Speed");
            headerRow.createCell(4).setCellValue("Distance");
            headerRow.createCell(5).setCellValue("FuelConsumption");
            headerRow.createCell(6).setCellValue("FuelType");
            headerRow.createCell(7).setCellValue("CO2Emission");
            headerRow.createCell(8).setCellValue("posição X");
            headerRow.createCell(9).setCellValue("posição Y");

            // Salva as alterações na planilha
            workbook.write(outputStream);
            System.out.println("Nova aba criada com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //public static void main(String[] args) {
       
    //}
}*/






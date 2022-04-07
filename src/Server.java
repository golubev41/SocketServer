import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        //Зашли в нужный нам порт
        ServerSocket serverSocket = new ServerSocket(8000);
        //Цикл для непрерывной работы сервера и ожидания других клиентов
        while (true) {
            //Создали серверный соккет, при этом создав туннель с клиентным сокетом
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент " + (++count) + " подключился " + " \n");

            //блок кода чтения
            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            //Создали выводной поток, который умеет хранить кеш
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(clientSocket.getOutputStream()));
            //(Запрос) входные данные клиента
            String request = reader.readLine();
            //------
            String[] parts = request.split(" ");
            //------
           // if (parts[0] == "v2" && parts[0] == "V2") {
                System.out.println("Получено: Вариант = " + parts[0] + " x = " + parts[1] + " y= " + parts[2] + " a= " + parts[3] + " w=" + parts[4] + "\n");
                double x = Double.parseDouble(parts[1]);
                double y = Double.parseDouble(parts[2]);
                double a = Double.parseDouble(parts[3]);
                double w = Double.parseDouble(parts[4]);
                double rez = v2.func(x, y, a, w);
                System.out.println("Рассчитано: Result= " + rez + "\n");
                //(Ответ) выходные данные
                String response = "Рассчитано: Result= " + rez + "\n";
                //Выводим все данные
                writer.write(response);
                writer.flush();
                //Три метода закрывающие "работу"

                writer.close();
                reader.close();
                clientSocket.close();
            //}
        }
        //так как работа серва в цикле нам не нужно закрывать работу сервера
        //serverSocket.close();

    }
}

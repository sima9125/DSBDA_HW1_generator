package lab1;

import java.io.*;

public class GeneratorMetric
{
    public static void main(String[] args) throws IOException {
        int s = 0;
        BufferedWriter writer;
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите личество строк:");
            s = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Введите имя выходного файла:");
            writer = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        long fileTime = System.currentTimeMillis(); // время для метрики, которое начинается с текущего и дальше увеличиваетс на рандомное время
        while(s>0)
        {
            // создается строка:
            // -metricId будет в диапозоне от 1 до 10
            // -timestamp (millis) будет начинаться с текущего время и дальше увеличиваться на величину от 1 до 250
            // -value будет в диапозоне от 10 до 500
            try
            {
                writeStringToFile(writer, String.join(",", String.valueOf(randomInt(1, 10)), String.valueOf(fileTime += randomInt(1, 250)), String.valueOf(randomInt(10, 500))));
                s--;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        writer.close();
    }

    public static int randomInt(int to, int from)
    {
        return to+(int)(Math.random()*from);
    }

    public static void writeStringToFile(BufferedWriter writer, String str)
    {
        try
        {
            writer.write(str + "\n");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
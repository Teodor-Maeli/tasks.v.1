import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;

public class task1 {
    public static void getFirstTask() {
        Path filePath = Path.of("C:\\Users\\tedodidi\\Desktop\\tasks-main\\tasks-main\\src\\text");
        //used to output only uniques
        TreeSet<String> sorted = new TreeSet<>();
        try {
            String text = Files.readString(filePath);
            String[] textList = text.split(" ");
            int counter = 1;
            for (int i = 0; i < textList.length; i++) {
                for (int j = 1; j < textList.length; j++) {
                    if (textList[i].equals(textList[j])) {
                        counter++;
                    }
                }
                //populating the loop within the array.
                sorted.add(textList[i] + " " + counter);
                counter = 0;
            }

            //forEach lambda for treeset output
            sorted.forEach((final1) -> {
                System.out.println(final1);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

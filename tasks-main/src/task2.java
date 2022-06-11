
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class task2 {


    static public void getSecondTask() {
        Path fileName = Path.of("C:\\Users\\tedodidi\\Desktop\\tasks-main\\tasks-main\\src\\text");
        try {
            String text = Files.readString(fileName);
            String[] splitted = text.split(" ");
            Stream<String> stringStream = Stream.of(splitted);
            stringStream.collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

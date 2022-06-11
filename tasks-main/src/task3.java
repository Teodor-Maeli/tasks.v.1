
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class task3 {
    public static void task3() throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\Teodor Maeli\\IdeaProjects\\homework1\\src\\iplog"));
        Scanner input1 = new Scanner(new File("C:\\Users\\Teodor Maeli\\IdeaProjects\\homework1\\src\\iplog"));
        ArrayList<String> text = new ArrayList<>();
        ArrayList<String> users = new ArrayList<>();
        //fetching data from the list into 2 different arrays;
        while (input.hasNext()) {
            text.add(input.nextLine());
        }
        while (input1.hasNext()) {
            users.add(input1.next());
        }
        ArrayList<String> ips = new ArrayList<>();
        Collections.sort(users);

        boolean validator = true;
        while (validator) {
            validator = false;
            if (users.get(0).contains("1")) {
                ips.add(users.get(0));
                users.remove(0);
                validator = true;

            }
        }
        //Initilazing map and populating it with the names of the users + creating new HashMap for each of them
        HashMap<String, LinkedHashMap<String, Integer>> finalsort = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            finalsort.put(users.get(i), new LinkedHashMap<>());
        }
        //while that will populate the the hashmaps with the key/values and at the same time removing data from text array
        while (!text.isEmpty()) {
            for (int i = 0; i < users.size(); i++) {
                int count = 1;
                for (int j = 0; j < ips.size(); j++) {
                    if (text.get(0).contains(ips.get(j))) {
                        if (text.get(0).contains(users.get(i))) {
                            finalsort.get(users.get(i)).put(text.get(0).substring(0, text.get(0).indexOf(" ")), count + 1);
                        }
                    } else {
                        if (text.get(0).contains(users.get(i))) {
                            finalsort.get(users.get(i)).put(text.get(0).substring(0, text.get(0).indexOf(" ")), 1);
                        }
                    }
                }

            }
            text.remove(0);
        }

        //output
        finalsort.forEach((key, value) -> {
            System.out.println(key);
            value.forEach((n, nums) -> {
                System.out.println(n + " => " + nums + " times");
            });
        });
    }
}

package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List readHumansFromFile(Path path) {
        List<String> temp = new ArrayList<>();

        try {
            temp = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }

        for (int i = 0; i < temp.size(); i++) {
            String[] a = new String[7];
            a = temp.get(i).split(";");
            humans.add(new Human(a[0], a[1]));
        }
        return humans;
    }


    public List filterMenData() {
        List<String> menString = new ArrayList<>();
        for (Human h : humans) {
            if (h.getIdentityNumber().charAt(0) == '3' || h.getIdentityNumber().charAt(0) == '1') {
                menString.add(h.getName() + ";" + h.getIdentityNumber());
            }
        }

        return menString;
    }

    public void writeMaleHumansToFile(Path path) {

        try {
            Files.write(path, filterMenData());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }


    public List<Human> getHumans() {
        return humans;
    }
}

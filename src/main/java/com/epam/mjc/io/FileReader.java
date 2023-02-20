package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        // reading the content of file
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(isr);
//            int ch = fileInputStream.read();
            String line;
            while((line = br.readLine()) !=null) {
                if (line.startsWith("Name: ")){
                    profile.setName(line.substring(7));
                }
                if (line.startsWith("Age: ")){
                    profile.setAge(Integer.valueOf(line.substring(6)));
                }
                if (line.startsWith("Email: ")){
                    profile.setEmail(line.substring(8));
                }
                if (line.startsWith("Phone: ")){
                    profile.setPhone(Long.valueOf(line.substring(8)));
                }
            }
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }

        // write the content in file
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String fileContent ="Name: " + profile.getName();
            fileOutputStream.write(fileContent.getBytes());
            fileContent ="Age: " + profile.getAge();
            fileOutputStream.write(fileContent.getBytes());
            fileContent ="Email: " + profile.getEmail();
            fileOutputStream.write(fileContent.getBytes());
            fileContent ="Phone: " + profile.getPhone();
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }


        return profile;
    }
}

package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) !=null) {
                if (line.startsWith("Name: ")){
                    profile.setName(line.substring(6));
                }
                if (line.startsWith("Age: ")){
                    profile.setAge(Integer.valueOf(line.substring(5)));
                }
                if (line.startsWith("Email: ")){
                    profile.setEmail(line.substring(7));
                }
                if (line.startsWith("Phone: ")){
                    profile.setPhone(Long.valueOf(line.substring(7)));
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String fileContent = profile.getName();
            fileOutputStream.write(fileContent.getBytes());
            fileContent = String.valueOf(profile.getAge());
            fileOutputStream.write(fileContent.getBytes());
            fileContent =  profile.getEmail();
            fileOutputStream.write(fileContent.getBytes());
            fileContent = String.valueOf(profile.getPhone());
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


        return profile;
    }
}

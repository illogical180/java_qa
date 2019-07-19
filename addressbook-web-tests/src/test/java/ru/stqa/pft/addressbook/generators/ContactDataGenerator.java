package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

        @Parameter(names = "-c", description = "Contact count")
        public int count;

        @Parameter(names = "-f", description = "Target file")
        public String file;

        @Parameter(names ="-d", description = "Data format")
        public String format;
        public static void main(String[] args) throws IOException {
            ru.stqa.pft.addressbook.generators.ContactDataGenerator generator = new ru.stqa.pft.addressbook.generators.ContactDataGenerator();
            JCommander jCommander = new JCommander(generator);
            try{
                jCommander.parse(args);
            } catch (ParameterException ex){
                jCommander.usage();
                return;
            }

            generator.run();
        }
    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognised format" + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)){
            writer.write(json);
        }

    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try(Writer writer = new FileWriter(file)){
            writer.write(xml);
        }
    }


    private  void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try(Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                writer.write(String.format("%s;%s;%s\n", contact.getFirstName(),
                        contact.getLastName(), contact.getEmail1(),contact.getEmail2(),contact.getEmail3(),contact.getPhoneNumber1(),contact.getPhoneNumber2(),contact.getPhoneNumber3()));
            }
        }
    }

    private  List<ContactData> generateContacts(int count){
        List<ContactData> contacts = new ArrayList<>();
        for (int i=0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("first %s", i))
                    .withLastname(String.format("last %s", i))
                    .withEmail1(String.format("email1 %s", i))
                    .withEmail2(String.format("email2 %s", i))
                    .withEmail3(String.format("email3 %s", i))
                    .withPhonenumber1(String.format("home %s", i))
                    .withPhonenumber2(String.format("mobile %s", i))
                    .withPhonenumber3(String.format("work %s", i)));
        }
        return contacts;
    }
}

package api.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlParser {
    public static void main(String[] args) {
//        try {
//
//            utils.xml.Person person = new utils.xml.Person();
//            person.setName("John");
//            person.setAge(30);
//
//            //Создается контекст JAXB
//            JAXBContext context = JAXBContext.newInstance(utils.xml.Person.class);
//
//            //Создается объект Marshaller
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            //Сериализация объекта в XML
//            StringWriter writer = new StringWriter();
//            marshaller.marshal(person, writer);
//            String xmlString = writer.toString();
//            System.out.println(xmlString);
//        } catch (JAXBException ex) {
//            ex.printStackTrace();
//        }

        try {
            String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<person>\n" +
                    "    <age>35</age>\n" +
                    "    <name>John</name>\n" +
                    "</person>";

            //Создается контекст JAXB
            JAXBContext context = JAXBContext.newInstance(Person.class);

            //Создается объект Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();

            //Десериализация объекта в POJO
            StringReader reader = new StringReader(xmlString);
            Person person = (Person) unmarshaller.unmarshal(reader);

            System.out.println(person);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

    }
}

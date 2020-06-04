package project;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLFile {
	public void writeToXMLFile(String file,CollectionExample users) throws JAXBException{
	
	    JAXBContext context = JAXBContext.newInstance(CollectionExample.class);
	   
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    
	    m.marshal(users, System.out);
	    
	    m.marshal(users, new File(file));
	}
	
	public CollectionExample readFromXMLFile(String file) throws JAXBException,FileNotFoundException{
	
	    JAXBContext context = JAXBContext.newInstance(CollectionExample.class);
	  
	    Unmarshaller um = context.createUnmarshaller();
	    CollectionExample group = (CollectionExample) um.unmarshal(new FileReader(file));

	    return group;
	}

}

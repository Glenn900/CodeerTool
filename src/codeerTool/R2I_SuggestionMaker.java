package codeerTool;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class R2I_SuggestionMaker implements SuggestionMaker {
	public void generate(int opnameNr)	{
		try	{
//			Riziv r1 = new Riziv();
//			Riziv r2 = new Riziv();
//			Riziv[] array = {r1,r2};
			
			InputSource inputSource = new InputSource("r2i.xml");
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();
			String expression = "tuples/tuple[contains(antecedent,'RIZIV=460821')]/antecedent/text()";
			XPathExpression xPathExpression = xPath.compile(expression);
			Object result = xPathExpression.evaluate(inputSource,XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeValue()); 
			}
		} catch (XPathExpressionException ex) {
    		ex.printStackTrace();
    	}
	}
}

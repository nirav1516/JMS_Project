package setupClasses;
import java.sql.SQLException;
import java.util.Properties;
import Connection.*;
import javax.jms.*;
import javax.naming.*;
import modelclasses.*;

public class jmsserver implements MessageListener {
	
	private Connection connection;
    private QueueConnection qcon;
	private Session session;
	private Topic counterTopic;
	private MessageConsumer consumer;
	private Queue queue;
	Service ser = new Service();
	
	@Override
	public void onMessage(Message message) {
		
    TextMessage TM = (TextMessage)message;
    String emailid = null;
    String password = null;
    String fname = null;
    String lname = null;
    
		try
		{   
			String request = TM.getText();
			System.out.println("in the onmsg " + request);
			
			String loginmsg = request.substring(0,5);
			if( loginmsg.equalsIgnoreCase("login")){   
				String[] att = request.split(";");
				System.out.println("inside" );
			    emailid = att[1];
				System.out.println("after emaild " + emailid );
				password = att[2];
				System.out.println("after password " + password );
				User result = null;
				try {
					result = ser.login(emailid , password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendObjectReply(message, result);
			}
			
			String registermsg = request.substring(0,8);
			System.out.println("registermsg " + registermsg);
			if( registermsg.equalsIgnoreCase("register")){   
				String[] att = request.split(";");
				System.out.println("inside register" );
				fname = att[1];
				lname = att[2];
				
			    emailid = att[3];
				System.out.println("after emaild " + emailid );
				password = att[4];
				System.out.println("after password " + password );
				String result = null;
				result = ser.register(fname, lname, emailid, password);
				sendReply(message, result);
			}
			
			
			if(request.toLowerCase().contains("addproducttocart")){
				String[] att = request.split(";");
				System.out.println("inside register" );
				String uid = att[1];
				String proid = att[2];
				
			    
				String result = null;
				result = ser.addproducttocart(uid, proid);
				sendReply(message, result);
			}
			
			
			if(request.toLowerCase().contains("fetchcartdata")){
				String catid,uid;
				String[] att = request.split(";");
				
				uid = att[1];
				System.out.println("after uid " + uid );
				Cart[] result = null;
				try {
					result = ser.fetchcartdata( uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendCartReply(message, result);
			}
			
			if( request.equalsIgnoreCase("fetchcatalog")){   
				
				Catalog[] result = null;
				try {
					result = ser.fetchcatlogs();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendcatalogReply(message, result);
			}
			
		    // String mssage = request.toString();
		    //fetchproducts
			String fetchproductsmsg = request.substring(0,13);
			if( fetchproductsmsg.equalsIgnoreCase("fetchproducts")){  
				String catid,uid;
				String[] att = request.split(";");
				System.out.println("inside" );
			    catid = att[1];
				System.out.println("after catid " + emailid );
				uid = att[2];
				System.out.println("after uid " + password );
				Product[] result = null;
				try {
					result = ser.fetchproducts(catid , uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendProductReply(message, result);
			}
			
			
			if(request.toLowerCase().contains("fetchorderdetail")){
				String catid,uid;
				String[] att = request.split(";");
				
				uid = att[1];
				System.out.println("after uid " + uid );
				Order[] result = null;
				try {
					result = ser.fetchorderdata( uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendOrderReply(message, result);
			}
			
			if(request.toLowerCase().contains("fetchsellinghistory")){
				String catid,uid;
				String[] att = request.split(";");
				
				uid = att[1];
				System.out.println("after uid " + uid );
				Sellinghistory[] result = null;
				try {
					result = ser.fetchSellingHistory(uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendHistoryReply(message, result);
			}
			
			if(request.toLowerCase().contains("fetchmyproducts")){
				String catid,uid;
				String[] att = request.split(";");
				
				uid = att[1];
				System.out.println("after uid " + password );
				Product[] result = null;
				try {
					result = ser.fetchMyproducts( uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sendProductReply(message, result);
			}
			
			
			if(request.toLowerCase().contains("insertproduct")){
				String[] att = request.split(";");
				System.out.println("inside insertproduct" );
				String uid = att[1];
				String catid = att[2];
				
				String proname = att[3];
				System.out.println("after proname " + proname );
				String prodesc = att[4];
				System.out.println("after password " + prodesc );
				String price = att[5];
				String qty = att[6];
				String result = null;
				result = ser.insertproduct(uid, catid, proname, prodesc, price, qty);
				sendReply(message, result);
			}
			
			
			if(request.toLowerCase().contains("generateorder")){
				String[] att = request.split(";");
				System.out.println("inside generateOrder" );
				String uid = att[1];
				
				String result = null;
				result = ser.generateOrder(uid);
				sendReply(message, result);
			}
			if(request.toLowerCase().contains("gettotalcart")){
				String[] att = request.split(";");
				System.out.println("inside insertproduct" );
				String uid = att[1];
				
				String result = null;
				result = String.valueOf(ser.gettotalcart(uid));
				sendReply(message, result);
			}
			
		    if(request.equalsIgnoreCase("rendercategory")){
				System.out.println("in the jms server render categories");
				String result = ""; //jms ser.rendercategory();
				sendReply(message, result);
			}
		    String productsmsg = request.substring(0,14);
		    if(productsmsg.equalsIgnoreCase("renderproducts")){
				System.out.println("in the jms server render renderproducts");
				String[] att = request.split(";");
				String catname = att[1];
				String result = ""; //jms//ser.renderproducts(catname);
				sendReply(message, result);
			}
		    String getnamemsg = request.substring(0,7);	
		   if(getnamemsg.equalsIgnoreCase("getname")){
				System.out.println("in the jms server render getname");
				String[] att = request.split(";");
				String emailId = att[1];
				String result = ""; //jmsser.getname(emailId);
				sendReply(message, result);
			}
		   
			
		  String addtocartmsg =  request.substring(0,9);  
		  if(addtocartmsg.equalsIgnoreCase("addtocart")){
				System.out.println("in the jms server addtocart");
				String[] att = request.split(";");
				String username = att[1];
				String productname = att[2];
				String result = ""; //jms ser.addtocart(username , productname);
				
				sendReply(message, result);
			}
		
	
			
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void sendReply(Message request, String result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			TextMessage TM = session.createTextMessage(result);
			MP.send(reply, TM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	
	public void sendObjectReply(Message request, User result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			//TextMessage TM = session.createTextMessage(result);
			ObjectMessage OM = session.createObjectMessage(result);
			MP.send(reply, OM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	
	
	public void sendcatalogReply(Message request, Catalog[] result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			//TextMessage TM = session.createTextMessage(result);
			ObjectMessage OM = session.createObjectMessage(result);
			MP.send(reply, OM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	//sendProductReply
	public void sendProductReply(Message request, Product[] result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			//TextMessage TM = session.createTextMessage(result);
			ObjectMessage OM = session.createObjectMessage(result);
			MP.send(reply, OM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	public void sendOrderReply(Message request, Order[] result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			//TextMessage TM = session.createTextMessage(result);
			ObjectMessage OM = session.createObjectMessage(result);
			MP.send(reply, OM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	public void sendHistoryReply(Message request, Sellinghistory[] result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			//TextMessage TM = session.createTextMessage(result);
			ObjectMessage OM = session.createObjectMessage(result);
			MP.send(reply, OM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	
	public void sendCartReply(Message request, Cart[] result)
	{
		try
		{
			MessageProducer MP = session.createProducer(null);
			Destination reply = request.getJMSReplyTo();
			//TextMessage TM = session.createTextMessage(result);
			ObjectMessage OM = session.createObjectMessage(result);
			MP.send(reply, OM);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	}
	
	public jmsserver(){
		try
		{
		    Properties properties = new Properties();
		    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		    properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		    properties.put(Context.PROVIDER_URL, "localhost");
		    
			InitialContext jndi = new InitialContext(properties);
			QueueConnectionFactory qconfac = (QueueConnectionFactory)jndi.lookup("XAConnectionFactory");
			//ConnectionFactory conFactory = (ConnectionFactory)jndi.lookup("XAConnectionFactory");
			//connection = qconfac.createConnection();
			qcon = qconfac.createQueueConnection();
			session = qcon.createSession( false, Session.AUTO_ACKNOWLEDGE );
			
			try
			{
				//counterTopic = (Topic)jndi.lookup("CounterTopic");
				queue = (Queue) jndi.lookup("Queue");
				
			}
			catch(NamingException NE1)
			{
				System.out.println("NamingException: "+NE1+ " : Continuing anyway...");
			}
			
		/*	if( null == counterTopic )
			{
				counterTopic = session.createTopic("CounterTopic");
				jndi.bind("CounterTopic", counterTopic);
			}*/
			if(queue == null){
				queue = session.createQueue("Queue");
				jndi.bind("Queue", queue);
			}
			
			
			
			consumer = session.createConsumer( queue );
			consumer.setMessageListener(this);
			System.out.println("Server started waiting for client requests");
			qcon.start();
		}
		catch(NamingException NE)
		{
			System.out.println("Naming Exception: "+NE);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
			JMSE.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		new jmsserver();
	}

}

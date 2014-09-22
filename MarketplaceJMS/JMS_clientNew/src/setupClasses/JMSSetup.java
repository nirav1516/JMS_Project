package setupClasses;

import javax.jms.*;
import javax.jms.Queue;

import java.util.*;
import modelclasses.*;

import javax.naming.*;
public class JMSSetup  {
	private Connection connection;
	private Session session;
	private Topic counterTopic;
	private MessageConsumer consumer;
	private Topic replyTopic;
	private Queue queue;
	private QueueConnection qcon;
	
	
	public JMSSetup()
	{
		try
		{
		    Properties properties = new Properties();
		    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		    properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		    properties.put(Context.PROVIDER_URL, "localhost");

			InitialContext jndi = new InitialContext(properties);
			ConnectionFactory conFactory = (ConnectionFactory)jndi.lookup("XAConnectionFactory");
			connection = conFactory.createConnection();

			session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
			//counterTopic = (Topic)jndi.lookup("CounterTopic");
            queue = (Queue)jndi.lookup("Queue");  
			connection.start();
			
			//System.out.println("after submitting movie " + submitmovie());

		}
		catch(NamingException NE)
		{
			System.out.println("Naming Exception: "+NE);
		}
		catch(JMSException JMSE)
		{
			System.out.println("JMS Exception: "+JMSE);
		}
	
	}
	
	
	public modelclasses.User login(java.lang.String username, java.lang.String pwd) throws JMSException {
		System.out.println("in the login method"); 
		   System.out.println("username " + username); 
		   System.out.println("password  " + pwd); 
	    User u = null;
	    
	    MessageProducer MP;
		TextMessage Reply = null ;
		ObjectMessage ob = null;
		
		try {
		
			MP = session.createProducer(queue);
			TextMessage TM = session.createTextMessage("login;" +username+";"+ pwd);
			//TextMessage emailid = session.createTextMessage(username);
			//TextMessage pass = session.createTextMessage(password);
			replyTopic = session.createTemporaryTopic();
			consumer = session.createConsumer( replyTopic );
          
			TM.setJMSReplyTo(replyTopic);
			MP.send(TM);
			
			//MP.send(emailid);
			System.out.println("after sending message"); 
			//MP.send(pass);
			//System.out.println("after sending message 1"); 
		    ob = (ObjectMessage)consumer.receive();
			//System.out.println("reply from server " + Reply.getText() );

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u = (User)(ob.getObject());
		return u;
		//return Reply.getText();
	  }
	
	public java.lang.String register(String fname, String lname, String email,String pwd) throws JMSException{
		 MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("register;"+ fname +";"+ lname +";"+ email +";"+ pwd);
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server for register : " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
		  }
	
	  public java.lang.String insertproduct(java.lang.String uid, java.lang.String catId, java.lang.String proname, java.lang.String prodesc, java.lang.String proprice, java.lang.String proqty) throws JMSException{
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("insertproduct;"+ uid +";"+ catId +";"+ proname +";"+ prodesc + ";"+ proprice + ";"+proqty);
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server for register : " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
		  }
		  
	 public modelclasses.Catalog[] fetchcatlogs() throws  JMSException{
		 Catalog[] ct = null;
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			ObjectMessage ob = null;
			
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("fetchcatalog");
				
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
				//MP.send(emailid);
				System.out.println("after sending message"); 
				//MP.send(pass);
				//System.out.println("after sending message 1"); 
			    ob = (ObjectMessage)consumer.receive();
				//System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = (Catalog[]) (ob.getObject());
			return ct;
		  }

	 public modelclasses.Product[] fetchproducts(java.lang.String procatid, java.lang.String uid) throws JMSException{
		 Product[] ct = null;
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			ObjectMessage ob = null;
			
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("fetchproducts;"+ procatid +";"+ uid);
				
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
				//MP.send(emailid);
				System.out.println("after sending message"); 
				//MP.send(pass);
				//System.out.println("after sending message 1"); 
			    ob = (ObjectMessage)consumer.receive();
				//System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = (Product[]) (ob.getObject());
			return ct;    
	}
	
	  public modelclasses.Product[] fetchMyproducts(java.lang.String uid) throws JMSException{
		  Product[] ct = null;
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			ObjectMessage ob = null;
			
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("fetchMyproducts;"+ uid);
				
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
				//MP.send(emailid);
				System.out.println("after sending message"); 
				//MP.send(pass);
				//System.out.println("after sending message 1"); 
			    ob = (ObjectMessage)consumer.receive();
				//System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = (Product[]) (ob.getObject());
			return ct; 
		  }
	
	  public modelclasses.Order[] fetchorderdata(java.lang.String uid) throws JMSException{
		  Order[] ct = null;
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			ObjectMessage ob = null;
			
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("fetchorderdetail;"+ uid);
				
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
				//MP.send(emailid);
				System.out.println("after sending message"); 
				//MP.send(pass);
				//System.out.println("after sending message 1"); 
			    ob = (ObjectMessage)consumer.receive();
				//System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = (Order[]) (ob.getObject());
			return ct;
		  }
	  
	  public modelclasses.Sellinghistory[] fetchSellingHistory(java.lang.String uid) throws JMSException{
		  Sellinghistory[] ct = null;
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			ObjectMessage ob = null;
			
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("fetchsellinghistory;"+ uid);
				
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
				//MP.send(emailid);
				System.out.println("after sending message"); 
				//MP.send(pass);
				//System.out.println("after sending message 1"); 
			    ob = (ObjectMessage)consumer.receive();
				//System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = (Sellinghistory[]) (ob.getObject());
			return ct;
		  }
	  
	  public java.lang.String addproducttocart(java.lang.String uid, java.lang.String proid) throws JMSException{
		  MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("addproducttocart;"+ uid +";"+ proid);
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server for register : " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText(); 
		  
		  }

	  public modelclasses.Cart[] fetchcartdata(java.lang.String uid) throws JMSException{
		  Cart[] ct = null;
		    
		    MessageProducer MP;
			TextMessage Reply = null ;
			ObjectMessage ob = null;
			
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("fetchcartdata;"+ uid);
				
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
				//MP.send(emailid);
				System.out.println("after sending message"); 
				//MP.send(pass);
				//System.out.println("after sending message 1"); 
			    ob = (ObjectMessage)consumer.receive();
				//System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct = (Cart[]) (ob.getObject());
			return ct; 
		  }
		  
		  public String gettotalcart(java.lang.String uid) throws JMSException{
			  MessageProducer MP;
				TextMessage Reply = null ;
				try {
				
					MP = session.createProducer(queue);
					TextMessage TM = session.createTextMessage("gettotalcart;"+ uid);
					//TextMessage emailid = session.createTextMessage(username);
					//TextMessage pass = session.createTextMessage(password);
					replyTopic = session.createTemporaryTopic();
					consumer = session.createConsumer( replyTopic );
		          
					TM.setJMSReplyTo(replyTopic);
					MP.send(TM);
					
				    Reply = (TextMessage)consumer.receive();
					System.out.println("reply from server for register : " + Reply.getText() );

				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Reply.getText(); 
		  }
		  
		  public java.lang.String generateOrder(java.lang.String uid) throws JMSException{
			  MessageProducer MP;
				TextMessage Reply = null ;
				try {
				
					MP = session.createProducer(queue);
					TextMessage TM = session.createTextMessage("generateOrder;"+ uid );
					//TextMessage emailid = session.createTextMessage(username);
					//TextMessage pass = session.createTextMessage(password);
					replyTopic = session.createTemporaryTopic();
					consumer = session.createConsumer( replyTopic );
		          
					TM.setJMSReplyTo(replyTopic);
					MP.send(TM);
					
				    Reply = (TextMessage)consumer.receive();
					System.out.println("reply from server for register : " + Reply.getText() );

				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Reply.getText(); 
			  }
		  
	public String getcartid(int userid) throws JMSException{
		
		  System.out.println("in the render categories in method "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("getcartid;" + userid);
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
		
	}
	
	public String getproductid(String productname) throws JMSException{
		
		  System.out.println("in the render categories in method "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("getproductid;" + productname);
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
		
	}
	
	public String addtocart(String username , String productname) throws JMSException{
		
		  System.out.println("in the render categories in method "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("addtocart;" + username + ";" + productname );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
		
	}
	
	public String rendercart(String emailId) throws JMSException{
		 System.out.println("in the show cart client "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("rendercart;" + emailId );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
	}

	
	public String checkout(String emailId) throws JMSException{
		 System.out.println("in the show cart client "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("checkout;" + emailId );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
	}
	
	public String pastActivities(String emailId) throws JMSException{
		 System.out.println("in the show cart client "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("pastActivities;" + emailId );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
	}
	
	public String pastsoldouts(String emailId) throws JMSException{
		 System.out.println("in the show cart client "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("checkout;" + emailId );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
	}
	
	
	public String addcategory(String productName) throws JMSException{
		 System.out.println("in the show cart client "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("addcategory;" + productName );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
	}
	
		public String addproduct(String emailid, String category,String itemname,String itemdiscription,String itemprice,String itemquantity,String sname,String saddress,String semailid)
 throws JMSException{
		 System.out.println("in the addproduct "); 
		   
			MessageProducer MP;
			TextMessage Reply = null ;
			try {
			
				MP = session.createProducer(queue);
				TextMessage TM = session.createTextMessage("addproduct?" + emailid+";"+category+";"+itemname+";"+itemdiscription+";"+itemprice+";"+itemquantity+";"+sname+";"+saddress+";"+semailid );
				//TextMessage emailid = session.createTextMessage(username);
				//TextMessage pass = session.createTextMessage(password);
				replyTopic = session.createTemporaryTopic();
				consumer = session.createConsumer( replyTopic );
	          
				TM.setJMSReplyTo(replyTopic);
				MP.send(TM);
				
			    Reply = (TextMessage)consumer.receive();
				System.out.println("reply from server " + Reply.getText() );

			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Reply.getText();
	}


		
	
	
}

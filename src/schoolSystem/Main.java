package schoolSystem;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";
	String user = "sa";
	String pass = "root";

	public static boolean addingStudentTable() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		String sqlDB = "CREATE TABLE Students " + "(id INTEGER not NULL, " + " fname VARCHAR(8), "
				+ " lname VARCHAR(8), " + " birthdate date, " + " PRIMARY KEY ( id ))";

		Connection conn = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;

	}

	public static boolean addingSubjectsTable() {
//		if(addingSubjectsTable() == true)
//		{

		String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		String sqlDB = "CREATE TABLE Subjects " + "(id INTEGER not NULL, " + " title VARCHAR(8), "
				+ " descc VARCHAR(250), " + " pricePerStudent decimal, " + " PRIMARY KEY ( id ))";

		Connection conn = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;

			} else {
				System.out.println(" table already Created in given database...");
			}

			conn.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}
//		}

		return false;

	}

	public static long addFakeStudents(long n) {

		try {

			String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

			String user = "sa";
			String pass = "root";
			String fName = "AHD";
			String lName = "ZAK";
			String birthDay = "1-11-2022";
			
			int min = 50;
            int max = 100;
			  int random = (int)Math.floor(Math.random()*(max-min+1)+min);
			  for(long i = 0; i<=n; i++ ) {
			String sqlDBss = "INSERT INTO Students VALUES(" + i+random + ",'" + (fName + i) + "','" + (lName + i) + "','"
					+ birthDay + "')";
			  

			Connection conn = null;

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			int m = st.executeUpdate(sqlDBss);

			if (m >= 1) {
				System.out.println("Values Inserted in given Table...");

			} else {
				System.out.println(" Values already Inserted in given database...");
			}

			conn.close();
			  }

		} catch (Exception ex) {
			System.err.println(ex);
		}
		
		return n;

	}

	public static long addFakeSubject(long n) {

		try {

			String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

			String user = "sa";
			String pass = "root";
			String title = "JAVA";
			String Desc = "JAVA IS BEST LANGUAGE";
			int pricePerStudent = 150;
           

            int min = 50;
            int max = 100;
      	  for(long i =0; i<=n; i++ ) {
            int random = (int)Math.floor(Math.random()*(max-min+1)+min);

			String sqlDBss = "INSERT INTO Subjects VALUES(" + i+random + ",'" + (title + i) + "','" + (Desc + i) + "',"
					+ pricePerStudent + ")";

			Connection conn = null;

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			int m = st.executeUpdate(sqlDBss);

			if (m >= 1) {
				System.out.println("Values Inserted in given Table...");

			} else {
				System.out.println(" Values already Inserted in given database...");
			}

			conn.close();
      	  }
		} catch (Exception ex) {
			System.err.println(ex);
		}

		return n;

	}

	public static void topStudent(int top) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		String sqlDB = "SELECT TOP"+top+"* FROM Students";

		Connection conn = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {

					System.out.println("id : " + m.getInt(1));
					System.out.println("fname :" + m.getString(2));
					System.out.println("lname :" + m.getString(3));
					System.out.println("birthdate :" + m.getDate(4));
					System.out.println("*********************************");

				} while (m.next());

			} else {
				System.out.println("No such user id is already registered");
			}

			conn.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void topStubject(int top) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

		String user = "sa";
		String pass = "root";

		String sqlDB = "SELECT TOP"+top+"* FROM Subjects";

		Connection conn = null;
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);

			Statement st = conn.createStatement();

			ResultSet m = st.executeQuery(sqlDB);

			if (m.next()) {

				do {

					System.out.println("id : " + m.getInt(1));
					System.out.println("title :" + m.getString(2));
					System.out.println("descc :" + m.getString(3));
					System.out.println("pricePerStudent :" + m.getBigDecimal(4));
					System.out.println("*********************************");

				} while (m.next());

			} else {
				System.out.println("No such user id is already registered");
			}

			conn.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean menuExit = true;
		boolean submenuExit = true;
		while (menuExit) {
			System.out.println("************************");
			System.out.println("1- Enter Student Table");
			System.out.println("2- Enter Subject Table");
			System.out.println("3- selects top 10 students");
			System.out.println("4- selects top 15 Subject ");
			System.out.println("5- Random values addFakeStudents");
			System.out.println("6- Random values addFakeSubject");
			System.out.println("7- Sub menu");
			System.out.println("************************");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println(addingStudentTable());

				break;

			case 2:
				System.out.println(addingSubjectsTable());

				break;

			case 3:
				topStudent(10);
				break;
			case 4:
				topStubject(15);
				break;
				
			case 5:
				System.out.println("Enter How many Random user you want to add");
				int number = scanner.nextInt();
				addFakeStudents(number);

				break;
				
			case 6:
				System.out.println("Enter How many Random user you want to add");
				long subnumber = scanner.nextInt();
				addFakeSubject(subnumber);

				break;
			case 7:

				while (submenuExit) {
					System.out.println("************************");
					System.out.println("1- List Top 100 Students");
					System.out.println("2- List Top 50 Subjects");
					System.out.println("3- Add a new Student");
					System.out.println("4- Add a new Subject");
					System.out.println("5- Load 1000000 student in Students Table");
					System.out.println("6- Load 100000 subjects in Subjects Table");
					System.out.println("7- Exit App");

					System.out.println("************************");
					int options = scanner.nextInt();

					switch (options) {
					case 1:
						System.out.println("How many TOP You want:");
						int top = scanner.nextInt();
						topStudent(top);
						break;
					case 2:
						System.out.println("How many TOP You want:");
						int topsub = scanner.nextInt();
						topStubject(topsub);

						break;
					case 3:

						String sqlurl = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

						String userss = "sa";
						String passw = "root";
						System.out.println("Enter Student ID :");
						int sId = scanner.nextInt();
						System.out.println("Enter Student First Name :");
						String fName = scanner.next();
						System.out.println("Enter Student Last Name :");
						String lName = scanner.next();
						System.out.println("Enter Student birthDay :");
						String birthDay = scanner.next();
						String sqlDBss = "INSERT INTO Students " + sId + ",'" + fName + "','" + lName + "','" + birthDay
								+ "'";

						Connection connt = null;
						try {

							Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
									.newInstance();
							DriverManager.registerDriver(driver);
							connt = DriverManager.getConnection(sqlurl, userss, passw);

							Statement st = connt.createStatement();

							int m = st.executeUpdate(sqlDBss);
							if (m >= 1) {
								System.out.println("Created Successfuly...");
							} else {
								System.out.println("  already Created ...");
							}
							connt.close();
						}

						catch (Exception ex) {
							System.err.println(ex);
						}

						break;
					case 4:
						String uurluser = "jdbc:sqlserver://localhost:1433;databaseName=SchoolMgt;encrypt=true;trustServerCertificate=true";

						String user1 = "sa";
						String passwoard = "root";

						System.out.println("Enter Subject ID :");
						int Ids = scanner.nextInt();
						System.out.println("Enter Subject title Name :");
						String title = scanner.next();
						System.out.println("Enter Subject description Last Name :");
						String descc = scanner.next();
						System.out.println("Enter Student birthDay :");
						double pricePerStudent = scanner.nextInt();
						String sqlBC = "INSERT INTO Subject " + Ids + ",'" + title + "','" + descc + "',"
								+ pricePerStudent + "";

						Connection conntion = null;
						try {

							Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
									.newInstance();
							DriverManager.registerDriver(driver);
							conntion = DriverManager.getConnection(uurluser, user1, passwoard);

							Statement st = conntion.createStatement();

							int m = st.executeUpdate(sqlBC);
							if (m >= 1) {
								System.out.println("Created Successfuly...");
							} else {
								System.out.println("  already Created ...");
							}
							conntion.close();
						}

						catch (Exception ex) {
							System.err.println(ex);
						}
						break;
					case 5:
//						System.out.println("Enter How many user you want to add");
//						int firstnumber = scanner.nextInt();
//						
//						for (int i = firstnumber; i < 100; i++) {
//							addFakeStudents(firstnumber);
						
						long numbers = 1000;
						addFakeStudents(numbers);
						

						break;
					case 6:
						
						long subjecynumber = 1000;
						addFakeSubject(subjecynumber);
						
						break;
					case 7:
						submenuExit = false;
						menuExit = false;
						break;

					}
				}

				break;
			}
		}


	}

}

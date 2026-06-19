import java.util.*;

public class Main {

	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		MemberDAO mdao = new MemberDAO();
		IssuedBookDAO idao = new IssuedBookDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1. add books");
			System.out.println("2. view books");
			System.out.println("3. search book by id");
			System.out.println("4. search book by title");
			System.out.println("5. delete the book");
			System.out.println("6. add member");
			System.out.println("7. view member details");
			System.out.println("8. search member by id");
			System.out.println("9. delete member");
			System.out.println("10. add Issued Books");
			System.out.println("11. view issued books");
			System.out.println("12. return book");
			System.out.println("13. view issued book by member id");
			System.out.println("14. exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter book id : ");
				int bookId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter book title : ");
				String title = sc.nextLine();
				System.out.println("Enter book author name : ");
				String author = sc.nextLine();
				Book book = new Book(bookId, title, author);
				boolean ans = dao.addBook(book);

				if (ans) {
					System.out.println("book added successfully");
				} else {
					System.out.println("failed to add book");
				}
				break;

			case 2:
				dao.viewBooks();
				break;

			case 3:
				System.out.println("enter book id : ");
				int id = sc.nextInt();
				dao.searchBookById(id);
				break;

			case 4:
				System.out.println("enter book title : ");
				sc.nextLine();
				String bookName = sc.nextLine();
				dao.searchBookByTitle(bookName);
				break;

			case 5:
				System.out.println("enter the book id to delete: ");
				int bookID = sc.nextInt();
				boolean res = dao.deleteBook(bookID);
				if (res) {
					System.out.println("book deleted successsfully");
				} else {
					System.out.println("failed to delete the book");
				}
				break;
				
			case 6:
				System.out.println("enter member id : ");
				int memberId = sc.nextInt();
				System.out.println("enter member name : ");
				sc.nextLine();
				String memberName = sc.nextLine();
				Members member = new Members(memberId, memberName);
				boolean result = mdao.addMember(member);
				if(result) {
					System.out.println("member added successfully");
				}
				else {
					System.out.println("failed to add member");
				}
				break;
				
			case 7:
				mdao.viewMembers();
				break;
				
			case 8:
				System.out.println("enter member id : ");
				int memberID = sc.nextInt();
				mdao.searchMemberById(memberID);
				break;
				
			case 9:
				System.out.println("enter member id to delete : ");
				int memberid = sc.nextInt();
				boolean answer = mdao.deleteMember(memberid);
				if(answer) {
					System.out.println("member deleted sucessfully");
				}
				else {
					System.out.println("failed to delete member");
				}
				break;
				
			case 10:
				System.out.println("enter issued book id : ");
				int issuedBookId = sc.nextInt();
				System.out.println("enter book id : ");
				int BookID = sc.nextInt();
				System.out.println("enter member id : ");
				int MemberID = sc.nextInt();
				IssuedBook is = new IssuedBook(issuedBookId, BookID, MemberID);
				boolean t = idao.issueBook(is);
				if(t) {
					System.out.println("issued book added successfully");
				}
				else {
					System.out.println("failed to add issued book");
				}
				break;
				
			case 11:
				idao.viewIssuedBook();
				break;
				
			case 12:
				System.out.println("enter the issued book id : ");
				int issueId = sc.nextInt();
				boolean i = idao.returnBook(issueId);
				if(i) {
					System.out.println("returned book successfully");
				}
				else {
					System.out.println("failed to return books");
				}
				break;
				
			case 13:
				System.out.println("enter issued book member id : ");
				int MemberId = sc.nextInt();
				idao.viewIssuedBookByMember(MemberId);
				break;
				
			case 14:
				System.out.println("exiting...");
				System.exit(0);
				break;

			default:
				System.out.println("enter valid case no");
			}

		}

	}
}

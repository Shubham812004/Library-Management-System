import java.sql.*;
public class IssuedBookDAO {
	public boolean issueBook(IssuedBook issuedBook) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "INSERT INTO issued_books VALUES(?, ?, ?)";
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, issuedBook.getIssueId());
			pstmt.setInt(2, issuedBook.getBookId());
			pstmt.setInt(3, issuedBook.getMemberId());
			int row = pstmt.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}
	
	public void viewIssuedBook() {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT b.title, m.member_name FROM issued_books i JOIN books b ON i.book_id = b.book_id JOIN members m ON i.member_id = m.member_id";
			pstmt = connect.prepareStatement(sql );
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				String memberName = rs.getString("member_name");
				
				System.out.println(title + " -> " + memberName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean returnBook(int issueId) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "DELETE from issued_books WHERE issue_id = ?";
			pstmt = connect.prepareStatement(sql );
			pstmt.setInt(1, issueId);
			int row = pstmt.executeUpdate();
			return row > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		
		
		return false;
	}
	
	public void viewIssuedBookByMember(int memberId) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT b.title FROM books b JOIN issued_books i ON i.book_id = b.book_id WHERE i.member_id = ?";
			pstmt = connect.prepareStatement(sql );
			pstmt.setInt(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				System.out.println(title);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
	}
}

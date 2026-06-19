import java.sql.*;

public class BookDAO {
	public boolean addBook(Book book) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();

			String sql = "INSERT INTO books VALUES(?, ?, ?)";
			pstmt = connect.prepareStatement(sql);

			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());

			int row = pstmt.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public void viewBooks() {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM books";
			pstmt = connect.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");

				System.out.println("book id : " + book_id);
				System.out.println("title : " + title);
				System.out.println("author : " + author);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(connect, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void searchBookById(int book_id) {
		Connection connect = null;
		PreparedStatement pstmt = null;

		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM books WHERE book_id = ?";
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int book_id1 = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");

				System.out.println("book id : " + book_id1);
				System.out.println("title : " + title);
				System.out.println("author : " + author);
				System.out.println();
			}
			else {
				System.out.println("book not found");
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
	
	public void searchBookByTitle(String title) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM books WHERE title = ?";
			pstmt = connect.prepareStatement(sql );
			
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title1 = rs.getString("title");
				String author = rs.getString("author");

				System.out.println("book id : " + book_id);
				System.out.println("title : " + title1);
				System.out.println("author : " + author);
				System.out.println();
			}
			else {
				System.out.println("book not found");
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
	
	public boolean deleteBook(int book_id) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "DELETE FROM books WHERE book_id = ?";
			pstmt = connect.prepareStatement(sql );
			pstmt.setInt(1, book_id);
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
}

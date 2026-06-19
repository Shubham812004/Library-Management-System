import java.sql.*;
public class MemberDAO {
	public boolean addMember(Members members) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "INSERT INTO members VALUES(?, ?)";
			pstmt = connect.prepareStatement(sql );
			pstmt.setInt(1, members.getMemberId());
			pstmt.setString(2, members.getMemberName());
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
	
	public void viewMembers() {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM members";
			pstmt = connect.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int memberId = rs.getInt("member_id");
				String memberName = rs.getString("member_name");
				
				System.out.println("member id : " + memberId);
				System.out.println("member name : " + memberName);
				System.out.println();
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
	
	public void searchMemberById(int memberId) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "SELECT * FROM members WHERE member_id = ?";
			pstmt = connect.prepareStatement(sql );
			pstmt.setInt(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int memberID = rs.getInt("member_id");
				String memberName = rs.getString("member_name");
				
				System.out.println("member id : " + memberID);
				System.out.println("member name : " + memberName);
				System.out.println();
			}
			else {
				System.out.println("member not found");
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
	
	public boolean deleteMember(int memberId) {
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = DBConnection.getConnection();
			String sql = "DELETE FROM members WHERE member_id = ?";
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, memberId);
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

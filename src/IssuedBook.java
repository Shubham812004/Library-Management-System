
public class IssuedBook {
	private int issueId;
	private int bookId;
	private int memberId;
	public IssuedBook(int issueId, int bookId, int memberId) {
		this.issueId = issueId;
		this.bookId = bookId;
		this.memberId = memberId;
	}
	public int getIssueId() {
		return issueId;
	}
	public int getBookId() {
		return bookId;
	}
	public int getMemberId() {
		return memberId;
	}
}

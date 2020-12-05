package org.example;
import java.sql.*;
import java.util.Scanner;

public class SearchBook {
    public void SearchBookMethod()
    {
        Connection conn=null;
        Statement st=null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);

        String url = "jdbc:postgresql://127.0.0.1:5432/library";
        String user = "postgres";
        String password = "kw1996";
        System.out.println("원하시는 책 제목을 입력하세요.");
        String book_name = scan.nextLine();
        String sql ="Select book_Nm_Info,author_Nm_Info,book_Image_Url from bookinfo where book_Nm_Info='"+book_name+"';";

        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.print("책 이름: ");
                System.out.print(rs.getString(1));
                System.out.print(" ");
                System.out.print("작가 이름: ");
                System.out.print(rs.getString(2));
                System.out.print(" ");
                System.out.print("이미지 URL: ");
                System.out.print(rs.getString(3));
                System.out.println();
                while(true) {
                    System.out.println("1.대여하기 2.리뷰 작성 3.리뷰 보기 4.나가기");
                    Integer b = scan.nextInt();
                    if (b == 1) {
                        System.out.println("대여가 완료되었습니다.");
                        String my_book_q = "insert into mybook values('"+book_name+"');";
                        st.executeUpdate(my_book_q);
                    }
                    if (b == 2) {
                        System.out.println("리뷰 내용 입력 :");
                        String book_review = scan.nextLine();
                        String book_review_q = "insert into reviewinfo (book_nm_info, book_review) values ('"+book_name+"','"+book_review+"')";

                        st.executeUpdate(book_review_q);
                        System.out.println("리뷰 작성 완료");
                    }
                    if (b == 3) {
                        System.out.println(book_name+"에 대한 리뷰입니다.");
                        String book_review_q = "Select book_Nm_Info,book_review from reviewinfo where book_Nm_Info='"+book_name+"';";
                        ResultSet rs_b_review = null;
                        rs_b_review = st.executeQuery(book_review_q);
                        if(rs_b_review != null) {
                            while(rs_b_review.next()) {
                                String b_name = rs_b_review.getString(1);
                                String b_review = rs_b_review.getString(2);
                                System.out.println("책 이름="+b_name+", 리뷰 내용="+b_review);
                            }
                        }
                        break;
                    }
                    if (b == 4) {
                        break;
                    }
                }
            }
        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        }
        finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException sqlEX) {
                System.out.println(sqlEX);
            }
        }
    }
}

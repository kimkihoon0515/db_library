package org.example;
import java.sql.*;
import java.util.Scanner;

public class PopularRank {
    public void PopularRankMethod()
    {
        Connection conn=null;
        Statement st=null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);

        String url = "jdbc:postgresql://127.0.0.1:5432/library";
        String user = "postgres";
        String password = "kw1996";

        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            System.out.print("Student: ");

            while (rs.next()) {
                while(true) {
                    System.out.println("인기 도서 검색");
                    System.out.println("1.랭킹 1~100 보기");
                    System.out.println("2.랭킹 101~200 보기");
                    System.out.println("3.랭킹 201~300 보기");
                    System.out.println("4.랭킹 301~400 보기");
                    System.out.println("5.랭킹 401~500 보기");
                    System.out.println("6.나가기");
                    System.out.println("선택 :");
                    Integer rank = scan.nextInt();
                    if(rank == 1){
                        String book_rank_q = "select RKI_NO,BOOK_NM_INFO from bookinfo where RKI_NO >=1 and RKI_NO <=100;";
                        ResultSet rs_b_rank1 = null;
                        rs_b_rank1 = st.executeQuery(book_rank_q);
                        if(rs_b_rank1 != null){
                            while(rs_b_rank1.next()){
                                String b_rank = rs_b_rank1.getString(1);
                                String b_name = rs_b_rank1.getString(2);
                                System.out.println("순위 :"+b_rank+",책 이름:"+b_name);
                            }
                        }
                    }
                    if(rank == 2){
                        String book_rank_q = "select RKI_NO,BOOK_NM_INFO from bookinfo where RKI_NO >100 and RKI_NO <=200;";
                        ResultSet rs_b_rank2 = null;
                        rs_b_rank2 = st.executeQuery(book_rank_q);
                        if(rs_b_rank2 != null){
                            while(rs_b_rank2.next()){
                                String b_rank = rs_b_rank2.getString(1);
                                String b_name = rs_b_rank2.getString(2);
                                System.out.println("순위 :"+b_rank+",책 이름:"+b_name);
                            }
                        }
                    }
                    if(rank == 3){
                        String book_rank_q = "select RKI_NO,BOOK_NM_INFO from bookinfo where RKI_NO >200 and RKI_NO <=300;";
                        ResultSet rs_b_rank3 = null;
                        rs_b_rank3 = st.executeQuery(book_rank_q);
                        if(rs_b_rank3 != null){
                            while(rs_b_rank3.next()){
                                String b_rank = rs_b_rank3.getString(1);
                                String b_name = rs_b_rank3.getString(2);
                                System.out.println("순위 :"+b_rank+",책 이름:"+b_name);
                            }
                        }
                    }
                    if(rank == 4){
                        String book_rank_q = "select RKI_NO,BOOK_NM_INFO from bookinfo where RKI_NO >300 and RKI_NO <=400;";
                        ResultSet rs_b_rank4 = null;
                        rs_b_rank4 = st.executeQuery(book_rank_q);
                        if(rs_b_rank4 != null){
                            while(rs_b_rank4.next()){
                                String b_rank = rs_b_rank4.getString(1);
                                String b_name = rs_b_rank4.getString(2);
                                System.out.println("순위 :"+b_rank+",책 이름:"+b_name);
                            }
                        }
                    }
                    if(rank == 5){
                        String book_rank_q = "select RKI_NO,BOOK_NM_INFO from bookinfo where RKI_NO >400 and RKI_NO <=500;";
                        ResultSet rs_b_rank5 = null;
                        rs_b_rank5 = st.executeQuery(book_rank_q);
                        if(rs_b_rank5 != null){
                            while(rs_b_rank5.next()){
                                String b_rank = rs_b_rank5.getString(1);
                                String b_name = rs_b_rank5.getString(2);
                                System.out.println("순위 :"+b_rank+",책 이름:"+b_name);
                            }
                        }
                    }
                    if(rank == 6){
                        break;
                    }
                }
            }
        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        } finally {
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

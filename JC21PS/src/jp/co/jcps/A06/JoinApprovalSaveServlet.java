package jp.co.jcps.A06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.jcps.Common.CommonCheck;
import jp.co.jcps.Common.DBConnection;

/**
 * 部員登録承認の登録処理
 */
@WebServlet("/JoinApprovalSave")
public class JoinApprovalSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ
	 */
	public JoinApprovalSaveServlet() {
		super();
	}

	/**
	 * POSTでリクエストされた場合
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 共通チェック
		if (!CommonCheck.existSession(request)) {
			// セッションが切れてる場合はログイン画面に遷移
			request.getRequestDispatcher("/Login").forward(request, response);
		}
		//リクエストのエンコードを指定
		request.setCharacterEncoding("UTF-8");

		// リクエストが情報を取得する
		String registUserId = request.getParameter("userId");
		boolean approval = request.getParameter("approval").equals("true");
		// セッションからログイン中のユーザーの部長クラブIDを取得する
		String leaderClubId = (String) request.getSession().getAttribute("leaderClubId");
		try {
			if (approval) {
				// 承認する場合
				/* TODO
				 * 部員登録申請を承認する場合のみ実行する処理（メソッド）を呼び出しなさい。
				 */


			}
			/*
			 * TODO
			 * 部員登録申請を承認する場合および拒否する場合どちらも実行する処理（メソッド）を呼び出しなさい。
			 */

		}catch(Exception e) {
			request.getRequestDispatcher("ERROR/Error.jsp").forward(request, response);
		}

		// TOP画面の呼び出し
		request.getRequestDispatcher("/JoinApprovalController").forward(request, response);
	}
	/**
	 * 部員テーブル(trn_club_member)にデータを登録する。
	 * @param registClubId 登録する部活ID
	 * @param registUserId 登録するユーザーID
	 * @throws Exception
	 */
	private void saveClubMember(String registClubId, String registUserId) throws Exception {

		//SQLを宣言
		/* TODO
		 * SQLを完成させなさい。
		 */
		String sql = "INSERT INTO ";
		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(registClubId);
		paramList.add(registUserId);

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		db.executeInsertUpdateQuery(sql, paramList);
	}

	/**
	 * 部員登録申請テーブル(trn_join_request)のデータを削除する。
	 * @param registClubId
	 * @param registUserId
	 * @throws Exception
	 */
	private void deleteJoinRequest(String registClubId, String registUserId) throws Exception {

		//SQLを宣言
		/* TODO
		 * SQLを完成させなさい。
		 */
		String sql = "DELETE FROM ";
		// SQLに埋め込むパラメータリストを定義
		List<String> paramList = new ArrayList<String>();
		paramList.add(registClubId);
		paramList.add(registUserId);

		// SQLを実行し結果を取得
		DBConnection db = new DBConnection();
		db.executeInsertUpdateQuery(sql, paramList);
	}
}

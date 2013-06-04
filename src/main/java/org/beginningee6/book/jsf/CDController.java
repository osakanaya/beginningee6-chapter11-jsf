package org.beginningee6.book.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.beginningee6.book.ejb.CDEJB;
import org.beginningee6.book.jpa.CD;

/**
 * マネージドBean。
 * 
 * CD情報登録ページの画面表示、および、
 * この画面からの登録実行を処理するマネージドBean。
 */
@ManagedBean
@RequestScoped
public class CDController {
	
	@EJB						// EJBの注入
	private CDEJB cdEJB;
	
	// 画面表示および画面入力に用いるデータ
	private CD cd = new CD();
	private List<CD> cdList = new ArrayList<CD>();
	
	/**
	 * CD情報登録ページ（newCD.xhtml）でフォームをサブミットした時に
	 * 実行されるアクションメソッド。
	 */
	public String doCreateCD() {
		
		cd = cdEJB.createCD(cd);
		cdList = cdEJB.findCDs();
		
		return "listCDs.xhtml";
	}

	/**
	 * cdプロパティの取得。
	 */
	public CD getCd() {
		
		return cd;
	}

	/**
	 * cdプロパティの設定。
	 */
	public void setCd(CD cd) {
		this.cd = cd;
	}

	/**
	 * cdリストプロパティの取得。
	 */
	public List<CD> getCdList() {
		return cdList;
	}

	/**
	 * cdリストプロパティの設定。
	 */
	public void setCdList(List<CD> cdList) {
		this.cdList = cdList;
	}
}

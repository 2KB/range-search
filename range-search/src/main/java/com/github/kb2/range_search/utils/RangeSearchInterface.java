package com.github.kb2.range_search.utils;

/**
 * 範囲検索をするためのメソッドを定義したインターフェース
 */
public interface RangeSearchInterface {

	/**
	 * From値を取得
	 * @return
	 */
	abstract long getFromValue();
	
	/**
	 * To値を取得
	 * @return
	 */
	abstract long getToValue();
}

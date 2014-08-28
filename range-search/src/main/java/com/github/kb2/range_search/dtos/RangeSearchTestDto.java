package com.github.kb2.range_search.dtos;

import com.github.kb2.range_search.utils.RangeSearchInterface;

/**
 * 範囲検索データを保持するクラス
 * 
 * RangeSearchInterfaceを継承して、二分探索法での範囲検索を可能にした
 */
public class RangeSearchTestDto implements RangeSearchInterface{

	public long fromVal;
	public long toVal;
	
	public RangeSearchTestDto(long fromVal, long toVal){
		this.fromVal = fromVal;
		this.toVal = toVal;
	}

	/**
	 * From値を取得
	 */
	@Override
	public long getFromValue() {
		return fromVal;
	}

	/**
	 * To値を取得
	 */
	@Override
	public long getToValue() {
		return toVal;
	}

}

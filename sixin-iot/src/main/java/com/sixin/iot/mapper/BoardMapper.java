package com.sixin.iot.mapper;

import com.sixin.iot.domain.Board;

import java.util.List;

public interface BoardMapper {
    /**
     * 广告牌记录列表
     *
     * @return
     */
    List<Board> selectBoardList(Board board);
    /**
     * 根据board_id批量删除数据
     * @param board_id
     */
    int deleteBoardByids(String[] board_id);
    /**
     * 添加广告牌信息
     * @param board
     * @return
     */
    int insertBoard(Board board);
    /**
     * 根据board_id选择数据
     * @param board_id
     * @return
     */
    Board selectByid(String board_id);

    /**
     * 保存用户修改
     * @param board
     * @return
     */
    int updateBoard(Board board);
    /**
     * 删除广告牌信息
     * @param board_id
     * @returni
     */
    int deleteBoardByid(String board_id);

    public List<Board> selectBoardByids(List<String> sfids);
}
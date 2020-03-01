package com.sixin.iot.service.impl;
import com.sixin.common.annotation.DataSource;
import com.sixin.common.enums.DataSourceType;
import com.sixin.common.core.text.Convert;
import com.sixin.iot.domain.Board;
import com.sixin.iot.mapper.BoardMapper;
import com.sixin.iot.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:  BoardSys
 * @description: 广告牌系统
 * @author: 饶泽敏
 * @create: 2019-12-25 15:10
 **/
@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardMapper boardMapper;

    /**
     * 查询广告牌记录列表
     *
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Board> selectBoardList(Board board) {
        return boardMapper.selectBoardList(board);
    }

    /**
     * 根据id批量删除数据
     * @param id
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteBoardByids(String board_id) {
        return boardMapper.deleteBoardByids(Convert.toStrArray(board_id));
    }

    /**
     * 添加广告牌公告数据
     * @param  Board
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int insertBoard(Board board) {
        return boardMapper.insertBoard(board);
    }

    /**
     * 根据board_id选择数据
     * @param board_id
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public Board selectByid(String board_id) {
        return boardMapper.selectByid(board_id);
    }

    /**
     * 删除广告牌信息
     * @param Board
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int deleteBoardByid(String board_id) {
        return boardMapper.deleteBoardByid(board_id);
    }

    /**
     * 保存用户修改
     * @param Board
     * @return
     */
    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public int updateBoard(Board board) {
        return boardMapper.updateBoard(board);
    }

    @Override
    @DataSource(value = DataSourceType.SXINFOM)
    public List<Board> selectBoardByids(List<String> sfids) {
        return boardMapper.selectBoardByids(sfids);
    }

}

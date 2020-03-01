package com.sixin.web.controller.iot;

import com.sixin.common.annotation.Log;
import com.sixin.common.core.controller.BaseController;
import com.sixin.common.core.domain.AjaxResult;
import com.sixin.common.enums.BusinessType;
import com.sixin.common.core.page.TableDataInfo;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.common.utils.poi.ExcelUtil;
import com.sixin.iot.domain.Board;
import com.sixin.iot.service.BoardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/iot/board")
public class BoardController extends BaseController {

    private String prefix = "iot/board";

    @Autowired
    private BoardService BoardService;

    @RequiresPermissions("iot:boardinfo:view")
    @GetMapping()
    public String Board(){
        return prefix+"/board";
    }

    /**
     * Board列表
     * @param board
     * @return
     */
    //@RequiresPermissions("iot:boardinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Board board){
        startPage();
        List<Board> list = BoardService.selectBoardList(board);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(){
        return prefix+"/add";
    }

    /**
     * 新增Board信息
     */
    @RequiresPermissions("iot:boardinfo:add")
    @Log(title = "Board信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Board board)
    {
        return toAjax(BoardService.insertBoard(board));
    }
    /**
     * 修改Board信息
     */
    @GetMapping("/edit/{board_id}")
    public String edit(@PathVariable("board_id") String board_id, ModelMap mmap)
    {
        Board board = BoardService.selectByid(board_id);
        mmap.put("board", board);
        return prefix + "/edit";
    }
    /**
     * 修改保存Board信息
     */
    @RequiresPermissions("iot:boardinfo:edit")
    @Log(title = "Board信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Board board)
    {
       // SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return toAjax(BoardService.updateBoard(board));
    }
    /**
     * 删除Board信息
     */
    @RequiresPermissions("iot:boardinfo:remove")
    @Log(title = "删除Board信息", businessType = BusinessType.DELETE)

    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
       // System.out.println("*******"+board_id);
        return toAjax(BoardService.deleteBoardByids(ids));
    }


    /**
     * 导出终端运转列表
     */
    @Log(title = "Board", businessType = BusinessType.EXPORT)
    @RequiresPermissions("iot:boardinfo:export")
    @PostMapping("/exportbysingle")
    @ResponseBody
    public AjaxResult exportBoardByIds(@RequestParam("sjids") List<String> sfids)
    {
        List<Board> list = BoardService.selectBoardByids(sfids);
        ExcelUtil<Board> util = new ExcelUtil<Board>(Board.class);
        return util.exportExcel(list, "board");
    }



}
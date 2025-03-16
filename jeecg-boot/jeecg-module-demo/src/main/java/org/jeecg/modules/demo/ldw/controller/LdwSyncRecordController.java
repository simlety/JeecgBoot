package org.jeecg.modules.demo.ldw.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.demo.ldw.entity.LdwSyncRecord;
import org.jeecg.modules.demo.ldw.service.ILdwSyncRecordService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: ldw_sync_record
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Api(tags="ldw_sync_record")
@RestController
@RequestMapping("/ldw/ldwSyncRecord")
@Slf4j
public class LdwSyncRecordController extends JeecgController<LdwSyncRecord, ILdwSyncRecordService> {
	@Autowired
	private ILdwSyncRecordService ldwSyncRecordService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ldwSyncRecord
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "ldw_sync_record-分页列表查询")
	@ApiOperation(value="ldw_sync_record-分页列表查询", notes="ldw_sync_record-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LdwSyncRecord>> queryPageList(LdwSyncRecord ldwSyncRecord,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<LdwSyncRecord> queryWrapper = QueryGenerator.initQueryWrapper(ldwSyncRecord, req.getParameterMap());
		Page<LdwSyncRecord> page = new Page<LdwSyncRecord>(pageNo, pageSize);
		IPage<LdwSyncRecord> pageList = ldwSyncRecordService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ldwSyncRecord
	 * @return
	 */
	@AutoLog(value = "ldw_sync_record-添加")
	@ApiOperation(value="ldw_sync_record-添加", notes="ldw_sync_record-添加")
	@RequiresPermissions("ldw:ldw_sync_record:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LdwSyncRecord ldwSyncRecord) {
		ldwSyncRecordService.save(ldwSyncRecord);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ldwSyncRecord
	 * @return
	 */
	@AutoLog(value = "ldw_sync_record-编辑")
	@ApiOperation(value="ldw_sync_record-编辑", notes="ldw_sync_record-编辑")
	@RequiresPermissions("ldw:ldw_sync_record:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LdwSyncRecord ldwSyncRecord) {
		ldwSyncRecordService.updateById(ldwSyncRecord);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ldw_sync_record-通过id删除")
	@ApiOperation(value="ldw_sync_record-通过id删除", notes="ldw_sync_record-通过id删除")
	@RequiresPermissions("ldw:ldw_sync_record:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ldwSyncRecordService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "ldw_sync_record-批量删除")
	@ApiOperation(value="ldw_sync_record-批量删除", notes="ldw_sync_record-批量删除")
	@RequiresPermissions("ldw:ldw_sync_record:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ldwSyncRecordService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "ldw_sync_record-通过id查询")
	@ApiOperation(value="ldw_sync_record-通过id查询", notes="ldw_sync_record-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LdwSyncRecord> queryById(@RequestParam(name="id",required=true) String id) {
		LdwSyncRecord ldwSyncRecord = ldwSyncRecordService.getById(id);
		if(ldwSyncRecord==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ldwSyncRecord);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ldwSyncRecord
    */
    @RequiresPermissions("ldw:ldw_sync_record:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LdwSyncRecord ldwSyncRecord) {
        return super.exportXls(request, ldwSyncRecord, LdwSyncRecord.class, "ldw_sync_record");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("ldw:ldw_sync_record:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LdwSyncRecord.class);
    }

	 /**
	  *   同步数据
	  *
	  * @return
	  */
	 @IgnoreAuth
	 @PostMapping(value = "/sync")
	 public Result<String> sync(@RequestBody Map maps) {
		 ldwSyncRecordService.sync(maps);
		 return Result.OK("同步成功！");
	 }

}

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
import org.jeecg.modules.demo.ldw.entity.LdwProductInfo;
import org.jeecg.modules.demo.ldw.service.ILdwProductInfoService;

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
 * @Description: ldw_product_info
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Api(tags="ldw_product_info")
@RestController
@RequestMapping("/ldw/ldwProductInfo")
@Slf4j
public class LdwProductInfoController extends JeecgController<LdwProductInfo, ILdwProductInfoService> {
	@Autowired
	private ILdwProductInfoService ldwProductInfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ldwProductInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "ldw_product_info-分页列表查询")
	@ApiOperation(value="ldw_product_info-分页列表查询", notes="ldw_product_info-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LdwProductInfo>> queryPageList(LdwProductInfo ldwProductInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<LdwProductInfo> queryWrapper = QueryGenerator.initQueryWrapper(ldwProductInfo, req.getParameterMap());
		Page<LdwProductInfo> page = new Page<LdwProductInfo>(pageNo, pageSize);
		IPage<LdwProductInfo> pageList = ldwProductInfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ldwProductInfo
	 * @return
	 */
	@AutoLog(value = "ldw_product_info-添加")
	@ApiOperation(value="ldw_product_info-添加", notes="ldw_product_info-添加")
	@RequiresPermissions("ldw:ldw_product_info:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LdwProductInfo ldwProductInfo) {
		ldwProductInfoService.save(ldwProductInfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ldwProductInfo
	 * @return
	 */
	@AutoLog(value = "ldw_product_info-编辑")
	@ApiOperation(value="ldw_product_info-编辑", notes="ldw_product_info-编辑")
	@RequiresPermissions("ldw:ldw_product_info:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LdwProductInfo ldwProductInfo) {
		ldwProductInfoService.updateById(ldwProductInfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ldw_product_info-通过id删除")
	@ApiOperation(value="ldw_product_info-通过id删除", notes="ldw_product_info-通过id删除")
	@RequiresPermissions("ldw:ldw_product_info:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ldwProductInfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "ldw_product_info-批量删除")
	@ApiOperation(value="ldw_product_info-批量删除", notes="ldw_product_info-批量删除")
	@RequiresPermissions("ldw:ldw_product_info:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ldwProductInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "ldw_product_info-通过id查询")
	@ApiOperation(value="ldw_product_info-通过id查询", notes="ldw_product_info-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LdwProductInfo> queryById(@RequestParam(name="id",required=true) String id) {
		LdwProductInfo ldwProductInfo = ldwProductInfoService.getById(id);
		if(ldwProductInfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ldwProductInfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ldwProductInfo
    */
    @RequiresPermissions("ldw:ldw_product_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LdwProductInfo ldwProductInfo) {
        return super.exportXls(request, ldwProductInfo, LdwProductInfo.class, "ldw_product_info");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("ldw:ldw_product_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LdwProductInfo.class);
    }

}

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
import org.jeecg.modules.demo.ldw.entity.LdwEbayListings;
import org.jeecg.modules.demo.ldw.service.ILdwEbayListingsService;

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
 * @Description: ldw_ebay_listings
 * @Author: jeecg-boot
 * @Date:   2025-03-23
 * @Version: V1.0
 */
@Api(tags="ldw_ebay_listings")
@RestController
@RequestMapping("/ldw/ldwEbayListings")
@Slf4j
public class LdwEbayListingsController extends JeecgController<LdwEbayListings, ILdwEbayListingsService> {
	@Autowired
	private ILdwEbayListingsService ldwEbayListingsService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ldwEbayListings
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "ldw_ebay_listings-分页列表查询")
	@ApiOperation(value="ldw_ebay_listings-分页列表查询", notes="ldw_ebay_listings-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<LdwEbayListings>> queryPageList(LdwEbayListings ldwEbayListings,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<LdwEbayListings> queryWrapper = QueryGenerator.initQueryWrapper(ldwEbayListings, req.getParameterMap());
		Page<LdwEbayListings> page = new Page<LdwEbayListings>(pageNo, pageSize);
		IPage<LdwEbayListings> pageList = ldwEbayListingsService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ldwEbayListings
	 * @return
	 */
	@AutoLog(value = "ldw_ebay_listings-添加")
	@ApiOperation(value="ldw_ebay_listings-添加", notes="ldw_ebay_listings-添加")
	@RequiresPermissions("ldw:ldw_ebay_listings:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody LdwEbayListings ldwEbayListings) {
		ldwEbayListingsService.save(ldwEbayListings);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ldwEbayListings
	 * @return
	 */
	@AutoLog(value = "ldw_ebay_listings-编辑")
	@ApiOperation(value="ldw_ebay_listings-编辑", notes="ldw_ebay_listings-编辑")
	@RequiresPermissions("ldw:ldw_ebay_listings:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody LdwEbayListings ldwEbayListings) {
		ldwEbayListingsService.updateById(ldwEbayListings);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ldw_ebay_listings-通过id删除")
	@ApiOperation(value="ldw_ebay_listings-通过id删除", notes="ldw_ebay_listings-通过id删除")
	@RequiresPermissions("ldw:ldw_ebay_listings:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		ldwEbayListingsService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "ldw_ebay_listings-批量删除")
	@ApiOperation(value="ldw_ebay_listings-批量删除", notes="ldw_ebay_listings-批量删除")
	@RequiresPermissions("ldw:ldw_ebay_listings:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ldwEbayListingsService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "ldw_ebay_listings-通过id查询")
	@ApiOperation(value="ldw_ebay_listings-通过id查询", notes="ldw_ebay_listings-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<LdwEbayListings> queryById(@RequestParam(name="id",required=true) String id) {
		LdwEbayListings ldwEbayListings = ldwEbayListingsService.getById(id);
		if(ldwEbayListings==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ldwEbayListings);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ldwEbayListings
    */
    @RequiresPermissions("ldw:ldw_ebay_listings:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, LdwEbayListings ldwEbayListings) {
        return super.exportXls(request, ldwEbayListings, LdwEbayListings.class, "ldw_ebay_listings");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("ldw:ldw_ebay_listings:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, LdwEbayListings.class);
    }

}

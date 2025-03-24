package org.jeecg.modules.demo.ldw.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.HashUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.config.shiro.IgnoreAuth;
import org.jeecg.modules.demo.ldw.entity.LdwSyncRecord;
import org.jeecg.modules.demo.ldw.entity.RequestVO;
import org.jeecg.modules.demo.ldw.service.*;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @Description: ldw_sync_record
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Api(tags = "ldw_sync_record")
@RestController
@RequestMapping("/ldw/ldwSyncRecord")
@Slf4j
public class LdwSyncRecordController extends JeecgController<LdwSyncRecord, ILdwSyncRecordService> {
    public static final String STRING_TIME = " 00:00:00";
    @Autowired
    private ILdwSyncRecordService ldwSyncRecordService;

    @Autowired
    private ILdwOrdersService ldwOrdersService;
    @Autowired
    private ILdwProductInfoService ldwProductInfoService;
    @Autowired
    private ILdwEbayListingsService ldwEbayListingsService;

    @Autowired
    private ILdwProductInventoryService ldwProductInventoryService;


    @Autowired
    private RedisUtil redisUtil;

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
    @ApiOperation(value = "ldw_sync_record-分页列表查询", notes = "ldw_sync_record-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<LdwSyncRecord>> queryPageList(LdwSyncRecord ldwSyncRecord,
                                                      @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                      HttpServletRequest req) {
        QueryWrapper<LdwSyncRecord> queryWrapper = QueryGenerator.initQueryWrapper(ldwSyncRecord, req.getParameterMap());
        Page<LdwSyncRecord> page = new Page<LdwSyncRecord>(pageNo, pageSize);
        IPage<LdwSyncRecord> pageList = ldwSyncRecordService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param ldwSyncRecord
     * @return
     */
    @AutoLog(value = "ldw_sync_record-添加")
    @ApiOperation(value = "ldw_sync_record-添加", notes = "ldw_sync_record-添加")
    @RequiresPermissions("ldw:ldw_sync_record:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody LdwSyncRecord ldwSyncRecord) {
        ldwSyncRecordService.save(ldwSyncRecord);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param ldwSyncRecord
     * @return
     */
    @AutoLog(value = "ldw_sync_record-编辑")
    @ApiOperation(value = "ldw_sync_record-编辑", notes = "ldw_sync_record-编辑")
    @RequiresPermissions("ldw:ldw_sync_record:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody LdwSyncRecord ldwSyncRecord) {
        ldwSyncRecordService.updateById(ldwSyncRecord);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "ldw_sync_record-通过id删除")
    @ApiOperation(value = "ldw_sync_record-通过id删除", notes = "ldw_sync_record-通过id删除")
    @RequiresPermissions("ldw:ldw_sync_record:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        ldwSyncRecordService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "ldw_sync_record-批量删除")
    @ApiOperation(value = "ldw_sync_record-批量删除", notes = "ldw_sync_record-批量删除")
    @RequiresPermissions("ldw:ldw_sync_record:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
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
    @ApiOperation(value = "ldw_sync_record-通过id查询", notes = "ldw_sync_record-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<LdwSyncRecord> queryById(@RequestParam(name = "id", required = true) String id) {
        LdwSyncRecord ldwSyncRecord = ldwSyncRecordService.getById(id);
        if (ldwSyncRecord == null) {
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


    @IgnoreAuth
    @PostMapping(value = "/syncOrders")
    public Result<String> syncOrders(@RequestBody RequestVO requestVO) {
        if (!checkRequestFrequency(requestVO)) {
            return Result.error("调用频繁，请稍后再试！");
        }
        String startTime = getDefaultTime(requestVO.getStartTime(), -2);
        String endTime = getDefaultTime(requestVO.getEndTime(), 2);
        requestVO.setStartTime(startTime);
        requestVO.setEndTime(endTime);
        log.info("订单同步开始时间：" + startTime + "，结束时间：" + endTime);
        log.info("订单同步参数：" + JSON.toJSONString(requestVO));
        ldwOrdersService.syncOrders(requestVO);
        return Result.OK("同步成功！");
    }

    @IgnoreAuth
    @PostMapping(value = "/syncProducts")
    public Result<String> syncProducts(@RequestBody RequestVO requestVO) {
        if (!checkRequestFrequency(requestVO)) {
            return Result.error("调用频繁，请稍后再试！");
        }
        String startTime = getDefaultTime(requestVO.getStartTime(), -2);
        String endTime = getDefaultTime(requestVO.getEndTime(), 2);
        requestVO.setStartTime(startTime);
        requestVO.setEndTime(endTime);
        log.info("产品同步开始时间：" + startTime + "，结束时间：" + endTime);
        log.info("产品同步参数：" + JSON.toJSONString(requestVO));
        ldwProductInfoService.syncProducts(requestVO);
        return Result.OK("同步成功！");
    }

    @IgnoreAuth
    @PostMapping(value = "/syncEbayListings")
    public Result<String> syncEbayListings(@RequestBody RequestVO requestVO) {
        try {
            if (!checkRequestFrequency(requestVO)) {
                return Result.error("调用频繁，请稍后再试！");
            }
            if (StrUtil.isBlank(requestVO.getRemoteConfigUrl())) {
                return Result.error("remoteConfigUrl is null！");
            }
            String startTime = getDefaultTime(requestVO.getStartTime(), -2);
            String endTime = getDefaultTime(requestVO.getEndTime(), 2);
            requestVO.setStartTime(startTime);
            requestVO.setEndTime(endTime);
            log.info("ebay销售管理同步开始时间：" + startTime + "，结束时间：" + endTime);
            log.info("ebay销售管理同步参数：" + JSON.toJSONString(requestVO));
            ldwEbayListingsService.syncEbayListings(requestVO);
            return Result.OK("同步成功！");
        } catch (Exception e) {
            LdwUtil.addErrorRecord("requestVO:" + JSON.toJSONString(requestVO), e, "ldw_ebay_listings");
        }
        return Result.error("同步失败！");
    }


    @IgnoreAuth
    @PostMapping(value = "/syncInventory")
    public Result<String> syncInventory(@RequestBody RequestVO requestVO) {
        try {
            if (!checkRequestFrequency(requestVO)) {
                return Result.error("调用频繁，请稍后再试！");
            }
            String startTime = getDefaultTime(requestVO.getStartTime(), -2);
            String endTime = getDefaultTime(requestVO.getEndTime(), 2);
            requestVO.setStartTime(startTime);
            requestVO.setEndTime(endTime);
            log.info("库存同步开始时间：" + startTime + "，结束时间：" + endTime);
            log.info("库存同步参数：" + JSON.toJSONString(requestVO));
            ldwProductInventoryService.syncInventory(requestVO);
            return Result.OK("库存同步成功！");
        } catch (Exception e) {
            LdwUtil.addErrorRecord("requestVO:" + JSON.toJSONString(requestVO), e, "ldw_product_inventory");
        }
        return Result.error("同步失败！");
    }

    /**
     * 获取默认时间
     *
     * @param time      传入的时间
     * @param offsetDay 偏移天数
     * @return 格式化后的时间
     */
    private String getDefaultTime(String time, int offsetDay) {
        return StrUtil.isBlank(time) ? (DateUtil.formatDate(DateUtil.offsetDay(DateUtil.date(), offsetDay)) + STRING_TIME) : time;
    }

    /**
     * 检查请求频率，相同参数在 30 分钟内只能调用一次
     *
     * @param requestVO 请求参数
     * @return 是否可以继续执行请求
     */
    private boolean checkRequestFrequency(RequestVO requestVO) {
        // 生成请求参数的哈希值作为 Redis 键
        String requestHash = String.valueOf(HashUtil.fnvHash(JSON.toJSONString(requestVO)));

        // 检查 Redis 中是否存在该请求
        Long lastRequestTime = (Long) redisUtil.get(requestHash);
        if (lastRequestTime != null && System.currentTimeMillis() - lastRequestTime < 30 * 60 * 1000) {
            // 30 分钟内已调用过相同参数的请求
            return false;
        }

        // 更新 Redis 中的时间戳
        redisUtil.set(requestHash, System.currentTimeMillis(), 30 * 60); // 设置缓存有效期为 30 分钟
        return true;
    }
}

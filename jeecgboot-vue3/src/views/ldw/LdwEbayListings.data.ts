import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '业务系统原始ID（需保持唯一性）',
    align:"center",
    dataIndex: 'listingBasicId'
   },
   {
    title: '来源渠道ID（关联渠道配置表）',
    align:"center",
    dataIndex: 'orderSourceId'
   },
   {
    title: '渠道名称（如eBay德国站）',
    align:"center",
    dataIndex: 'orderSourceName'
   },
   {
    title: '系统SKU（最大长度50字符，唯一商品编码）',
    align:"center",
    dataIndex: 'sku'
   },
   {
    title: '渠道SKU（平台侧商品编码，最大长度100）',
    align:"center",
    dataIndex: 'orderSourceSku'
   },
   {
    title: '平台商品ID（eBay API返回的ItemID）',
    align:"center",
    dataIndex: 'itemId'
   },
   {
    title: '商品标题（德语，最大长度500字符）',
    align:"center",
    dataIndex: 'productTitle'
   },
   {
    title: '站点代码（遵循eBay站点编码规范，如DE）',
    align:"center",
    dataIndex: 'siteCode'
   },
   {
    title: '主分类（平台分类体系一级类目）',
    align:"center",
    dataIndex: 'primaryCategory'
   },
   {
    title: '二级分类（平台分类体系二级类目）',
    align:"center",
    dataIndex: 'secondaryCategory'
   },
   {
    title: '完整分类路径（平台分类全路径，分隔符:）',
    align:"center",
    dataIndex: 'allCategory'
   },
   {
    title: '一级产品类目（内部产品类目体系）',
    align:"center",
    dataIndex: 'primaryProductCategory'
   },
   {
    title: '二级产品类目（内部产品类目体系）',
    align:"center",
    dataIndex: 'secondaryProductCategory'
   },
   {
    title: '三级产品类目（内部产品类目体系）',
    align:"center",
    dataIndex: 'threeProductCategory'
   },
   {
    title: '完整产品类目路径（内部分类全路径）',
    align:"center",
    dataIndex: 'allProductCategory'
   },
   {
    title: '中文产品名称（最大长度300字符）',
    align:"center",
    dataIndex: 'productNameCn'
   },
   {
    title: '销售价格（含小数点精度，最大9999999999.99）',
    align:"center",
    dataIndex: 'sellingPrice'
   },
   {
    title: '货币代码（ISO 4217标准，如EUR/USD）',
    align:"center",
    dataIndex: 'currency'
   },
   {
    title: '周销量（自然周统计，自动更新）',
    align:"center",
    dataIndex: 'salesWeek'
   },
   {
    title: '两周销量（滚动统计周期）',
    align:"center",
    dataIndex: 'salesTwoWeek'
   },
   {
    title: '月销量（自然月统计）',
    align:"center",
    dataIndex: 'salesMonth'
   },
   {
    title: '三月销量（季度滚动统计）',
    align:"center",
    dataIndex: 'salesThreeMonth'
   },
   {
    title: '上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）',
    align:"center",
    dataIndex: 'onSelfTime'
   },
   {
    title: '下架时间（UTC时区，自动记录）',
    align:"center",
    dataIndex: 'soldOutTime'
   },
   {
    title: '添加人（员工账号名称，AD账号）',
    align:"center",
    dataIndex: 'addItemAdminName'
   },
   {
    title: '业务团队（事业部名称，如3C事业部）',
    align:"center",
    dataIndex: 'businessTeamName'
   },
   {
    title: '刊登费用（平台服务费，货币与currency字段一致）',
    align:"center",
    dataIndex: 'addItemFee'
   },
   {
    title: '在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '商品链接（平台商品详情页URL）',
    align:"center",
    dataIndex: 'productSellLink'
   },
   {
    title: '变体状态：0-无变体 1-父变体 2-子变体 3-变体异常',
    align:"center",
    dataIndex: 'variationStatus'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '业务系统原始ID（需保持唯一性）',
    field: 'listingBasicId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入业务系统原始ID（需保持唯一性）!'},
          ];
     },
  },
  {
    label: '来源渠道ID（关联渠道配置表）',
    field: 'orderSourceId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入来源渠道ID（关联渠道配置表）!'},
          ];
     },
  },
  {
    label: '渠道名称（如eBay德国站）',
    field: 'orderSourceName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入渠道名称（如eBay德国站）!'},
          ];
     },
  },
  {
    label: '系统SKU（最大长度50字符，唯一商品编码）',
    field: 'sku',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入系统SKU（最大长度50字符，唯一商品编码）!'},
          ];
     },
  },
  {
    label: '渠道SKU（平台侧商品编码，最大长度100）',
    field: 'orderSourceSku',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入渠道SKU（平台侧商品编码，最大长度100）!'},
          ];
     },
  },
  {
    label: '平台商品ID（eBay API返回的ItemID）',
    field: 'itemId',
    component: 'Input',
  },
  {
    label: '商品标题（德语，最大长度500字符）',
    field: 'productTitle',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入商品标题（德语，最大长度500字符）!'},
          ];
     },
  },
  {
    label: '站点代码（遵循eBay站点编码规范，如DE）',
    field: 'siteCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入站点代码（遵循eBay站点编码规范，如DE）!'},
          ];
     },
  },
  {
    label: '主分类（平台分类体系一级类目）',
    field: 'primaryCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入主分类（平台分类体系一级类目）!'},
          ];
     },
  },
  {
    label: '二级分类（平台分类体系二级类目）',
    field: 'secondaryCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入二级分类（平台分类体系二级类目）!'},
          ];
     },
  },
  {
    label: '完整分类路径（平台分类全路径，分隔符:）',
    field: 'allCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入完整分类路径（平台分类全路径，分隔符:）!'},
          ];
     },
  },
  {
    label: '一级产品类目（内部产品类目体系）',
    field: 'primaryProductCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入一级产品类目（内部产品类目体系）!'},
          ];
     },
  },
  {
    label: '二级产品类目（内部产品类目体系）',
    field: 'secondaryProductCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入二级产品类目（内部产品类目体系）!'},
          ];
     },
  },
  {
    label: '三级产品类目（内部产品类目体系）',
    field: 'threeProductCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入三级产品类目（内部产品类目体系）!'},
          ];
     },
  },
  {
    label: '完整产品类目路径（内部分类全路径）',
    field: 'allProductCategory',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入完整产品类目路径（内部分类全路径）!'},
          ];
     },
  },
  {
    label: '中文产品名称（最大长度300字符）',
    field: 'productNameCn',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入中文产品名称（最大长度300字符）!'},
          ];
     },
  },
  {
    label: '销售价格（含小数点精度，最大9999999999.99）',
    field: 'sellingPrice',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入销售价格（含小数点精度，最大9999999999.99）!'},
          ];
     },
  },
  {
    label: '货币代码（ISO 4217标准，如EUR/USD）',
    field: 'currency',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入货币代码（ISO 4217标准，如EUR/USD）!'},
          ];
     },
  },
  {
    label: '周销量（自然周统计，自动更新）',
    field: 'salesWeek',
    component: 'InputNumber',
  },
  {
    label: '两周销量（滚动统计周期）',
    field: 'salesTwoWeek',
    component: 'InputNumber',
  },
  {
    label: '月销量（自然月统计）',
    field: 'salesMonth',
    component: 'InputNumber',
  },
  {
    label: '三月销量（季度滚动统计）',
    field: 'salesThreeMonth',
    component: 'InputNumber',
  },
  {
    label: '上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）',
    field: 'onSelfTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '下架时间（UTC时区，自动记录）',
    field: 'soldOutTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '添加人（员工账号名称，AD账号）',
    field: 'addItemAdminName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入添加人（员工账号名称，AD账号）!'},
          ];
     },
  },
  {
    label: '业务团队（事业部名称，如3C事业部）',
    field: 'businessTeamName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入业务团队（事业部名称，如3C事业部）!'},
          ];
     },
  },
  {
    label: '刊登费用（平台服务费，货币与currency字段一致）',
    field: 'addItemFee',
    component: 'InputNumber',
  },
  {
    label: '在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架',
    field: 'status',
    component: 'InputNumber',
  },
  {
    label: '商品链接（平台商品详情页URL）',
    field: 'productSellLink',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入商品链接（平台商品详情页URL）!'},
          ];
     },
  },
  {
    label: '变体状态：0-无变体 1-父变体 2-子变体 3-变体异常',
    field: 'variationStatus',
    component: 'InputNumber',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  listingBasicId: {title: '业务系统原始ID（需保持唯一性）',order: 0,view: 'number', type: 'number',},
  orderSourceId: {title: '来源渠道ID（关联渠道配置表）',order: 1,view: 'number', type: 'number',},
  orderSourceName: {title: '渠道名称（如eBay德国站）',order: 2,view: 'text', type: 'string',},
  sku: {title: '系统SKU（最大长度50字符，唯一商品编码）',order: 3,view: 'text', type: 'string',},
  orderSourceSku: {title: '渠道SKU（平台侧商品编码，最大长度100）',order: 4,view: 'text', type: 'string',},
  itemId: {title: '平台商品ID（eBay API返回的ItemID）',order: 5,view: 'text', type: 'string',},
  productTitle: {title: '商品标题（德语，最大长度500字符）',order: 6,view: 'text', type: 'string',},
  siteCode: {title: '站点代码（遵循eBay站点编码规范，如DE）',order: 7,view: 'text', type: 'string',},
  primaryCategory: {title: '主分类（平台分类体系一级类目）',order: 8,view: 'text', type: 'string',},
  secondaryCategory: {title: '二级分类（平台分类体系二级类目）',order: 9,view: 'text', type: 'string',},
  allCategory: {title: '完整分类路径（平台分类全路径，分隔符:）',order: 10,view: 'text', type: 'string',},
  primaryProductCategory: {title: '一级产品类目（内部产品类目体系）',order: 11,view: 'text', type: 'string',},
  secondaryProductCategory: {title: '二级产品类目（内部产品类目体系）',order: 12,view: 'text', type: 'string',},
  threeProductCategory: {title: '三级产品类目（内部产品类目体系）',order: 13,view: 'text', type: 'string',},
  allProductCategory: {title: '完整产品类目路径（内部分类全路径）',order: 14,view: 'text', type: 'string',},
  productNameCn: {title: '中文产品名称（最大长度300字符）',order: 15,view: 'text', type: 'string',},
  sellingPrice: {title: '销售价格（含小数点精度，最大9999999999.99）',order: 16,view: 'number', type: 'number',},
  currency: {title: '货币代码（ISO 4217标准，如EUR/USD）',order: 17,view: 'text', type: 'string',},
  salesWeek: {title: '周销量（自然周统计，自动更新）',order: 18,view: 'number', type: 'number',},
  salesTwoWeek: {title: '两周销量（滚动统计周期）',order: 19,view: 'number', type: 'number',},
  salesMonth: {title: '月销量（自然月统计）',order: 20,view: 'number', type: 'number',},
  salesThreeMonth: {title: '三月销量（季度滚动统计）',order: 21,view: 'number', type: 'number',},
  onSelfTime: {title: '上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）',order: 22,view: 'datetime', type: 'string',},
  soldOutTime: {title: '下架时间（UTC时区，自动记录）',order: 23,view: 'datetime', type: 'string',},
  addItemAdminName: {title: '添加人（员工账号名称，AD账号）',order: 24,view: 'text', type: 'string',},
  businessTeamName: {title: '业务团队（事业部名称，如3C事业部）',order: 25,view: 'text', type: 'string',},
  addItemFee: {title: '刊登费用（平台服务费，货币与currency字段一致）',order: 26,view: 'number', type: 'number',},
  status: {title: '在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架',order: 27,view: 'number', type: 'number',},
  productSellLink: {title: '商品链接（平台商品详情页URL）',order: 28,view: 'text', type: 'string',},
  variationStatus: {title: '变体状态：0-无变体 1-父变体 2-子变体 3-变体异常',order: 29,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
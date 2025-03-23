import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '关联订单ID',
    align:"center",
    dataIndex: 'orderId'
   },
   {
    title: '冗余订单号（用于快速查询）',
    align:"center",
    dataIndex: 'orderCode'
   },
   {
    title: '系统SKU编号',
    align:"center",
    dataIndex: 'sku'
   },
   {
    title: '客户自定义SKU',
    align:"center",
    dataIndex: 'clientSku'
   },
   {
    title: '组合产品SKU',
    align:"center",
    dataIndex: 'groupSku'
   },
   {
    title: '组合产品客户SKU',
    align:"center",
    dataIndex: 'groupClientSku'
   },
   {
    title: '组合产品数量',
    align:"center",
    dataIndex: 'groupProductNum'
   },
   {
    title: '组合产品售价',
    align:"center",
    dataIndex: 'groupProductPrice'
   },
   {
    title: '产品数量',
    align:"center",
    dataIndex: 'productNum'
   },
   {
    title: '产品单价',
    align:"center",
    dataIndex: 'productPrice'
   },
   {
    title: '运费收入',
    align:"center",
    dataIndex: 'shippingPrice'
   },
   {
    title: '最新采购价（人民币）',
    align:"center",
    dataIndex: 'lastBuyPrice'
   },
   {
    title: '供应商报价（人民币）',
    align:"center",
    dataIndex: 'lastSupplierPrice'
   },
   {
    title: '头程运费（人民币）',
    align:"center",
    dataIndex: 'firstLegFee'
   },
   {
    title: '进口关税（人民币）',
    align:"center",
    dataIndex: 'tariffFee'
   },
   {
    title: '平台渠道SKU',
    align:"center",
    dataIndex: 'sellerSku'
   },
   {
    title: '平台商品项ID',
    align:"center",
    dataIndex: 'orderItemId'
   },
   {
    title: '亚马逊标准识别号',
    align:"center",
    dataIndex: 'asin'
   },
   {
    title: '商品规格参数',
    align:"center",
    dataIndex: 'parameterValues'
   },
   {
    title: '商品标题',
    align:"center",
    dataIndex: 'itemTitle'
   },
   {
    title: '是否生成包裹（0:否 1:是）',
    align:"center",
    dataIndex: 'isBuildPackage'
   },
   {
    title: '商品重量（克）',
    align:"center",
    dataIndex: 'productWeight'
   },
   {
    title: '商品长度（厘米）',
    align:"center",
    dataIndex: 'productLength'
   },
   {
    title: '商品宽度（厘米）',
    align:"center",
    dataIndex: 'productWidth'
   },
   {
    title: '商品高度（厘米）',
    align:"center",
    dataIndex: 'productHeight'
   },
   {
    title: '销售人员ID',
    align:"center",
    dataIndex: 'businessAdminId'
   },
   {
    title: '销售人员英文名',
    align:"center",
    dataIndex: 'businessAdminNameEn'
   },
   {
    title: '销售人员姓名',
    align:"center",
    dataIndex: 'businessAdminName'
   },
   {
    title: '开发人员ID',
    align:"center",
    dataIndex: 'developAdminId'
   },
   {
    title: '开发人员英文名',
    align:"center",
    dataIndex: 'developAdminNameEn'
   },
   {
    title: '开发人员姓名',
    align:"center",
    dataIndex: 'developAdminName'
   },
   {
    title: '商品详情页链接',
    align:"center",
    dataIndex: 'productLinks'
   },
   {
    title: '最新成本价',
    align:"center",
    dataIndex: 'productLatestCost'
   },
   {
    title: '商品净重（克）',
    align:"center",
    dataIndex: 'netWeight'
   },
   {
    title: '商品税费',
    align:"center",
    dataIndex: 'itemTax'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '关联订单ID',
    field: 'orderId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入关联订单ID!'},
          ];
     },
  },
  {
    label: '冗余订单号（用于快速查询）',
    field: 'orderCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入冗余订单号（用于快速查询）!'},
          ];
     },
  },
  {
    label: '系统SKU编号',
    field: 'sku',
    component: 'Input',
  },
  {
    label: '客户自定义SKU',
    field: 'clientSku',
    component: 'Input',
  },
  {
    label: '组合产品SKU',
    field: 'groupSku',
    component: 'Input',
  },
  {
    label: '组合产品客户SKU',
    field: 'groupClientSku',
    component: 'Input',
  },
  {
    label: '组合产品数量',
    field: 'groupProductNum',
    component: 'InputNumber',
  },
  {
    label: '组合产品售价',
    field: 'groupProductPrice',
    component: 'InputNumber',
  },
  {
    label: '产品数量',
    field: 'productNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入产品数量!'},
          ];
     },
  },
  {
    label: '产品单价',
    field: 'productPrice',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入产品单价!'},
          ];
     },
  },
  {
    label: '运费收入',
    field: 'shippingPrice',
    component: 'InputNumber',
  },
  {
    label: '最新采购价（人民币）',
    field: 'lastBuyPrice',
    component: 'InputNumber',
  },
  {
    label: '供应商报价（人民币）',
    field: 'lastSupplierPrice',
    component: 'InputNumber',
  },
  {
    label: '头程运费（人民币）',
    field: 'firstLegFee',
    component: 'InputNumber',
  },
  {
    label: '进口关税（人民币）',
    field: 'tariffFee',
    component: 'InputNumber',
  },
  {
    label: '平台渠道SKU',
    field: 'sellerSku',
    component: 'Input',
  },
  {
    label: '平台商品项ID',
    field: 'orderItemId',
    component: 'Input',
  },
  {
    label: '亚马逊标准识别号',
    field: 'asin',
    component: 'Input',
  },
  {
    label: '商品规格参数',
    field: 'parameterValues',
    component: 'InputTextArea',
  },
  {
    label: '商品标题',
    field: 'itemTitle',
    component: 'InputTextArea',
  },
  {
    label: '是否生成包裹（0:否 1:是）',
    field: 'isBuildPackage',
    component: 'InputNumber',
  },
  {
    label: '商品重量（克）',
    field: 'productWeight',
    component: 'InputNumber',
  },
  {
    label: '商品长度（厘米）',
    field: 'productLength',
    component: 'InputNumber',
  },
  {
    label: '商品宽度（厘米）',
    field: 'productWidth',
    component: 'InputNumber',
  },
  {
    label: '商品高度（厘米）',
    field: 'productHeight',
    component: 'InputNumber',
  },
  {
    label: '销售人员ID',
    field: 'businessAdminId',
    component: 'InputNumber',
  },
  {
    label: '销售人员英文名',
    field: 'businessAdminNameEn',
    component: 'Input',
  },
  {
    label: '销售人员姓名',
    field: 'businessAdminName',
    component: 'Input',
  },
  {
    label: '开发人员ID',
    field: 'developAdminId',
    component: 'InputNumber',
  },
  {
    label: '开发人员英文名',
    field: 'developAdminNameEn',
    component: 'Input',
  },
  {
    label: '开发人员姓名',
    field: 'developAdminName',
    component: 'Input',
  },
  {
    label: '商品详情页链接',
    field: 'productLinks',
    component: 'InputTextArea',
  },
  {
    label: '最新成本价',
    field: 'productLatestCost',
    component: 'InputNumber',
  },
  {
    label: '商品净重（克）',
    field: 'netWeight',
    component: 'InputNumber',
  },
  {
    label: '商品税费',
    field: 'itemTax',
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
  orderId: {title: '关联订单ID',order: 0,view: 'number', type: 'number',},
  orderCode: {title: '冗余订单号（用于快速查询）',order: 1,view: 'text', type: 'string',},
  sku: {title: '系统SKU编号',order: 2,view: 'text', type: 'string',},
  clientSku: {title: '客户自定义SKU',order: 3,view: 'text', type: 'string',},
  groupSku: {title: '组合产品SKU',order: 4,view: 'text', type: 'string',},
  groupClientSku: {title: '组合产品客户SKU',order: 5,view: 'text', type: 'string',},
  groupProductNum: {title: '组合产品数量',order: 6,view: 'number', type: 'number',},
  groupProductPrice: {title: '组合产品售价',order: 7,view: 'number', type: 'number',},
  productNum: {title: '产品数量',order: 8,view: 'number', type: 'number',},
  productPrice: {title: '产品单价',order: 9,view: 'number', type: 'number',},
  shippingPrice: {title: '运费收入',order: 10,view: 'number', type: 'number',},
  lastBuyPrice: {title: '最新采购价（人民币）',order: 11,view: 'number', type: 'number',},
  lastSupplierPrice: {title: '供应商报价（人民币）',order: 12,view: 'number', type: 'number',},
  firstLegFee: {title: '头程运费（人民币）',order: 13,view: 'number', type: 'number',},
  tariffFee: {title: '进口关税（人民币）',order: 14,view: 'number', type: 'number',},
  sellerSku: {title: '平台渠道SKU',order: 15,view: 'text', type: 'string',},
  orderItemId: {title: '平台商品项ID',order: 16,view: 'text', type: 'string',},
  asin: {title: '亚马逊标准识别号',order: 17,view: 'text', type: 'string',},
  parameterValues: {title: '商品规格参数',order: 18,view: 'textarea', type: 'string',},
  itemTitle: {title: '商品标题',order: 19,view: 'textarea', type: 'string',},
  isBuildPackage: {title: '是否生成包裹（0:否 1:是）',order: 20,view: 'number', type: 'number',},
  productWeight: {title: '商品重量（克）',order: 21,view: 'number', type: 'number',},
  productLength: {title: '商品长度（厘米）',order: 22,view: 'number', type: 'number',},
  productWidth: {title: '商品宽度（厘米）',order: 23,view: 'number', type: 'number',},
  productHeight: {title: '商品高度（厘米）',order: 24,view: 'number', type: 'number',},
  businessAdminId: {title: '销售人员ID',order: 25,view: 'number', type: 'number',},
  businessAdminNameEn: {title: '销售人员英文名',order: 26,view: 'text', type: 'string',},
  businessAdminName: {title: '销售人员姓名',order: 27,view: 'text', type: 'string',},
  developAdminId: {title: '开发人员ID',order: 28,view: 'number', type: 'number',},
  developAdminNameEn: {title: '开发人员英文名',order: 29,view: 'text', type: 'string',},
  developAdminName: {title: '开发人员姓名',order: 30,view: 'text', type: 'string',},
  productLinks: {title: '商品详情页链接',order: 31,view: 'textarea', type: 'string',},
  productLatestCost: {title: '最新成本价',order: 32,view: 'number', type: 'number',},
  netWeight: {title: '商品净重（克）',order: 33,view: 'number', type: 'number',},
  itemTax: {title: '商品税费',order: 34,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
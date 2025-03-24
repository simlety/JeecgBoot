import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '产品SKU（平台标准识别码）',
    align:"center",
    dataIndex: 'sku'
   },
   {
    title: '客户自定义SKU（最大长度255）',
    align:"center",
    dataIndex: 'clientSku'
   },
   {
    title: '仓库名称（包含仓库编码信息）',
    align:"center",
    dataIndex: 'warehouseName'
   },
   {
    title: '可用库存数量',
    align:"center",
    dataIndex: 'goodNum'
   },
   {
    title: '锁定库存数量',
    align:"center",
    dataIndex: 'lockNum'
   },
   {
    title: '亚马逊标准识别号（ASIN）',
    align:"center",
    dataIndex: 'asin'
   },
   {
    title: '销售渠道SKU',
    align:"center",
    dataIndex: 'sellerSku'
   },
   {
    title: '商品活跃天数',
    align:"center",
    dataIndex: 'activeDays'
   },
   {
    title: '最近活跃时间',
    align:"center",
    dataIndex: 'activeTime'
   },
   {
    title: '仓库库位编码',
    align:"center",
    dataIndex: 'positionCode'
   },
   {
    title: '处理中的库存数量',
    align:"center",
    dataIndex: 'processingNum'
   },
   {
    title: '历史累计入库数量',
    align:"center",
    dataIndex: 'historyInNum'
   },
   {
    title: '历史累计出库数量',
    align:"center",
    dataIndex: 'historyOutNum'
   },
   {
    title: '最近7天出库数量',
    align:"center",
    dataIndex: 'outputNum'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '产品SKU（平台标准识别码）',
    field: 'sku',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入产品SKU（平台标准识别码）!'},
          ];
     },
  },
  {
    label: '客户自定义SKU（最大长度255）',
    field: 'clientSku',
    component: 'Input',
  },
  {
    label: '仓库名称（包含仓库编码信息）',
    field: 'warehouseName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入仓库名称（包含仓库编码信息）!'},
          ];
     },
  },
  {
    label: '可用库存数量',
    field: 'goodNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入可用库存数量!'},
          ];
     },
  },
  {
    label: '锁定库存数量',
    field: 'lockNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入锁定库存数量!'},
          ];
     },
  },
  {
    label: '亚马逊标准识别号（ASIN）',
    field: 'asin',
    component: 'Input',
  },
  {
    label: '销售渠道SKU',
    field: 'sellerSku',
    component: 'Input',
  },
  {
    label: '商品活跃天数',
    field: 'activeDays',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入商品活跃天数!'},
          ];
     },
  },
  {
    label: '最近活跃时间',
    field: 'activeTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '仓库库位编码',
    field: 'positionCode',
    component: 'Input',
  },
  {
    label: '处理中的库存数量',
    field: 'processingNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入处理中的库存数量!'},
          ];
     },
  },
  {
    label: '历史累计入库数量',
    field: 'historyInNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入历史累计入库数量!'},
          ];
     },
  },
  {
    label: '历史累计出库数量',
    field: 'historyOutNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入历史累计出库数量!'},
          ];
     },
  },
  {
    label: '最近7天出库数量',
    field: 'outputNum',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入最近7天出库数量!'},
          ];
     },
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
  sku: {title: '产品SKU（平台标准识别码）',order: 0,view: 'text', type: 'string',},
  clientSku: {title: '客户自定义SKU（最大长度255）',order: 1,view: 'text', type: 'string',},
  warehouseName: {title: '仓库名称（包含仓库编码信息）',order: 2,view: 'text', type: 'string',},
  goodNum: {title: '可用库存数量',order: 3,view: 'number', type: 'number',},
  lockNum: {title: '锁定库存数量',order: 4,view: 'number', type: 'number',},
  asin: {title: '亚马逊标准识别号（ASIN）',order: 5,view: 'text', type: 'string',},
  sellerSku: {title: '销售渠道SKU',order: 6,view: 'text', type: 'string',},
  activeDays: {title: '商品活跃天数',order: 7,view: 'number', type: 'number',},
  activeTime: {title: '最近活跃时间',order: 8,view: 'datetime', type: 'string',},
  positionCode: {title: '仓库库位编码',order: 9,view: 'text', type: 'string',},
  processingNum: {title: '处理中的库存数量',order: 10,view: 'number', type: 'number',},
  historyInNum: {title: '历史累计入库数量',order: 11,view: 'number', type: 'number',},
  historyOutNum: {title: '历史累计出库数量',order: 12,view: 'number', type: 'number',},
  outputNum: {title: '最近7天出库数量',order: 13,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
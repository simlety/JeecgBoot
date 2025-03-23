import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '系统订单号（业务唯一标识）',
    align:"center",
    dataIndex: 'orderCode'
   },
   {
    title: '平台订单号',
    align:"center",
    dataIndex: 'clientOrderCode'
   },
   {
    title: 'Ebay订单号',
    align:"center",
    dataIndex: 'salesRecordNumber'
   },
   {
    title: '交易号',
    align:"center",
    dataIndex: 'transactionId'
   },
   {
    title: '客户ID',
    align:"center",
    dataIndex: 'clientUserAccount'
   },
   {
    title: '邮箱',
    align:"center",
    dataIndex: 'email'
   },
   {
    title: '电话',
    align:"center",
    dataIndex: 'telephone'
   },
   {
    title: '来源渠道ID',
    align:"center",
    dataIndex: 'orderSourceId'
   },
   {
    title: '来源渠道名称',
    align:"center",
    dataIndex: 'orderSourceName'
   },
   {
    title: '付款状态（0:未付 1:已付）',
    align:"center",
    dataIndex: 'isPay'
   },
   {
    title: '平台支付方式',
    align:"center",
    dataIndex: 'paymentMethods'
   },
   {
    title: '订单状态',
    align:"center",
    dataIndex: 'orderStatus'
   },
   {
    title: '订单发货状态',
    align:"center",
    dataIndex: 'orderState'
   },
   {
    title: '订单添加时间',
    align:"center",
    dataIndex: 'addTime'
   },
   {
    title: '订单支付时间',
    align:"center",
    dataIndex: 'payTime'
   },
   {
    title: '订单使用币种',
    align:"center",
    dataIndex: 'currency'
   },
   {
    title: '订单总金额',
    align:"center",
    dataIndex: 'totalPrice'
   },
   {
    title: '优惠金额',
    align:"center",
    dataIndex: 'promotionDiscountAmount'
   },
   {
    title: '客户支付运费',
    align:"center",
    dataIndex: 'transportPay'
   },
   {
    title: '收货人国家代码',
    align:"center",
    dataIndex: 'country'
   },
   {
    title: '收货人省份',
    align:"center",
    dataIndex: 'province'
   },
   {
    title: '收货人城市',
    align:"center",
    dataIndex: 'city'
   },
   {
    title: '公司名称',
    align:"center",
    dataIndex: 'companyName'
   },
   {
    title: '邮政编码',
    align:"center",
    dataIndex: 'postCode'
   },
   {
    title: '收货人名',
    align:"center",
    dataIndex: 'firstName'
   },
   {
    title: '收货人姓',
    align:"center",
    dataIndex: 'lastName'
   },
   {
    title: '完整地址',
    align:"center",
    dataIndex: 'address'
   },
   {
    title: '地址行1',
    align:"center",
    dataIndex: 'address1'
   },
   {
    title: '地址行2',
    align:"center",
    dataIndex: 'address2'
   },
   {
    title: '地址行3',
    align:"center",
    dataIndex: 'address3'
   },
   {
    title: '区县名称',
    align:"center",
    dataIndex: 'district'
   },
   {
    title: '柜号',
    align:"center",
    dataIndex: 'cabinetNo'
   },
   {
    title: '发货方式ID',
    align:"center",
    dataIndex: 'transportId'
   },
   {
    title: '发货方式名称',
    align:"center",
    dataIndex: 'transportName'
   },
   {
    title: '订单备注描述',
    align:"center",
    dataIndex: 'orderDescription'
   },
   {
    title: '是否FBA订单（0:否 1:是）',
    align:"center",
    dataIndex: 'isFbaOrder'
   },
   {
    title: '发货仓库ID',
    align:"center",
    dataIndex: 'warehouseId'
   },
   {
    title: '订单总重量（克）',
    align:"center",
    dataIndex: 'productWeight'
   },
   {
    title: '平台配送服务名称',
    align:"center",
    dataIndex: 'shipService'
   },
   {
    title: '物流追踪号码',
    align:"center",
    dataIndex: 'trackNumbers'
   },
   {
    title: 'Paypal手续费',
    align:"center",
    dataIndex: 'paypalFee'
   },
   {
    title: '退款返还Paypal手续费',
    align:"center",
    dataIndex: 'refundPaypalFee'
   },
   {
    title: 'Paypal交易手续费',
    align:"center",
    dataIndex: 'paypalTransactionFee'
   },
   {
    title: '支付方式名称',
    align:"center",
    dataIndex: 'paymentTypeName'
   },
   {
    title: '支付方式代码',
    align:"center",
    dataIndex: 'paymentTypeValue'
   },
   {
    title: '物流商单号',
    align:"center",
    dataIndex: 'logisticsOrderNo'
   },
   {
    title: '物流商转单号',
    align:"center",
    dataIndex: 'logisticsOrderNo1'
   },
   {
    title: '是否备库订单（0:否 1:是）',
    align:"center",
    dataIndex: 'isStockOrder'
   },
   {
    title: '亚马逊备库单ID',
    align:"center",
    dataIndex: 'shipmentId'
   },
   {
    title: '买家订单号',
    align:"center",
    dataIndex: 'sellerOrderId'
   },
   {
    title: '订单来源渠道类型',
    align:"center",
    dataIndex: 'orderSourceType'
   },
   {
    title: '实际发货时间',
    align:"center",
    dataIndex: 'shipTime'
   },
   {
    title: '是否加密（0:未加密 1:已加密）',
    align:"center",
    dataIndex: 'encrypted'
   },
   {
    title: '门牌号码',
    align:"center",
    dataIndex: 'houseNumber'
   },
   {
    title: '包裹IDs（多个用逗号分隔）',
    align:"center",
    dataIndex: 'packagedIds'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '系统订单号（业务唯一标识）',
    field: 'orderCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入系统订单号（业务唯一标识）!'},
          ];
     },
  },
  {
    label: '平台订单号',
    field: 'clientOrderCode',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入平台订单号!'},
          ];
     },
  },
  {
    label: 'Ebay订单号',
    field: 'salesRecordNumber',
    component: 'InputNumber',
  },
  {
    label: '交易号',
    field: 'transactionId',
    component: 'Input',
  },
  {
    label: '客户ID',
    field: 'clientUserAccount',
    component: 'Input',
  },
  {
    label: '邮箱',
    field: 'email',
    component: 'Input',
  },
  {
    label: '电话',
    field: 'telephone',
    component: 'Input',
  },
  {
    label: '来源渠道ID',
    field: 'orderSourceId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入来源渠道ID!'},
          ];
     },
  },
  {
    label: '来源渠道名称',
    field: 'orderSourceName',
    component: 'Input',
  },
  {
    label: '付款状态（0:未付 1:已付）',
    field: 'isPay',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入付款状态（0:未付 1:已付）!'},
          ];
     },
  },
  {
    label: '平台支付方式',
    field: 'paymentMethods',
    component: 'Input',
  },
  {
    label: '订单状态',
    field: 'orderStatus',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入订单状态!'},
          ];
     },
  },
  {
    label: '订单发货状态',
    field: 'orderState',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入订单发货状态!'},
          ];
     },
  },
  {
    label: '订单添加时间',
    field: 'addTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入订单添加时间!'},
          ];
     },
  },
  {
    label: '订单支付时间',
    field: 'payTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入订单支付时间!'},
          ];
     },
  },
  {
    label: '订单使用币种',
    field: 'currency',
    component: 'Input',
  },
  {
    label: '订单总金额',
    field: 'totalPrice',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入订单总金额!'},
          ];
     },
  },
  {
    label: '优惠金额',
    field: 'promotionDiscountAmount',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入优惠金额!'},
          ];
     },
  },
  {
    label: '客户支付运费',
    field: 'transportPay',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入客户支付运费!'},
          ];
     },
  },
  {
    label: '收货人国家代码',
    field: 'country',
    component: 'Input',
  },
  {
    label: '收货人省份',
    field: 'province',
    component: 'Input',
  },
  {
    label: '收货人城市',
    field: 'city',
    component: 'Input',
  },
  {
    label: '公司名称',
    field: 'companyName',
    component: 'Input',
  },
  {
    label: '邮政编码',
    field: 'postCode',
    component: 'Input',
  },
  {
    label: '收货人名',
    field: 'firstName',
    component: 'Input',
  },
  {
    label: '收货人姓',
    field: 'lastName',
    component: 'Input',
  },
  {
    label: '完整地址',
    field: 'address',
    component: 'Input',
  },
  {
    label: '地址行1',
    field: 'address1',
    component: 'Input',
  },
  {
    label: '地址行2',
    field: 'address2',
    component: 'Input',
  },
  {
    label: '地址行3',
    field: 'address3',
    component: 'Input',
  },
  {
    label: '区县名称',
    field: 'district',
    component: 'Input',
  },
  {
    label: '柜号',
    field: 'cabinetNo',
    component: 'Input',
  },
  {
    label: '发货方式ID',
    field: 'transportId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发货方式ID!'},
          ];
     },
  },
  {
    label: '发货方式名称',
    field: 'transportName',
    component: 'Input',
  },
  {
    label: '订单备注描述',
    field: 'orderDescription',
    component: 'InputTextArea',
  },
  {
    label: '是否FBA订单（0:否 1:是）',
    field: 'isFbaOrder',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否FBA订单（0:否 1:是）!'},
          ];
     },
  },
  {
    label: '发货仓库ID',
    field: 'warehouseId',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发货仓库ID!'},
          ];
     },
  },
  {
    label: '订单总重量（克）',
    field: 'productWeight',
    component: 'InputNumber',
  },
  {
    label: '平台配送服务名称',
    field: 'shipService',
    component: 'Input',
  },
  {
    label: '物流追踪号码',
    field: 'trackNumbers',
    component: 'Input',
  },
  {
    label: 'Paypal手续费',
    field: 'paypalFee',
    component: 'InputNumber',
  },
  {
    label: '退款返还Paypal手续费',
    field: 'refundPaypalFee',
    component: 'InputNumber',
  },
  {
    label: 'Paypal交易手续费',
    field: 'paypalTransactionFee',
    component: 'InputNumber',
  },
  {
    label: '支付方式名称',
    field: 'paymentTypeName',
    component: 'Input',
  },
  {
    label: '支付方式代码',
    field: 'paymentTypeValue',
    component: 'InputNumber',
  },
  {
    label: '物流商单号',
    field: 'logisticsOrderNo',
    component: 'Input',
  },
  {
    label: '物流商转单号',
    field: 'logisticsOrderNo1',
    component: 'Input',
  },
  {
    label: '是否备库订单（0:否 1:是）',
    field: 'isStockOrder',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入是否备库订单（0:否 1:是）!'},
          ];
     },
  },
  {
    label: '亚马逊备库单ID',
    field: 'shipmentId',
    component: 'Input',
  },
  {
    label: '买家订单号',
    field: 'sellerOrderId',
    component: 'Input',
  },
  {
    label: '订单来源渠道类型',
    field: 'orderSourceType',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入订单来源渠道类型!'},
          ];
     },
  },
  {
    label: '实际发货时间',
    field: 'shipTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '是否加密（0:未加密 1:已加密）',
    field: 'encrypted',
    component: 'InputNumber',
  },
  {
    label: '门牌号码',
    field: 'houseNumber',
    component: 'Input',
  },
  {
    label: '包裹IDs（多个用逗号分隔）',
    field: 'packagedIds',
    component: 'Input',
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
  orderCode: {title: '系统订单号（业务唯一标识）',order: 0,view: 'text', type: 'string',},
  clientOrderCode: {title: '平台订单号',order: 1,view: 'text', type: 'string',},
  salesRecordNumber: {title: 'Ebay订单号',order: 2,view: 'number', type: 'number',},
  transactionId: {title: '交易号',order: 3,view: 'text', type: 'string',},
  clientUserAccount: {title: '客户ID',order: 4,view: 'text', type: 'string',},
  email: {title: '邮箱',order: 5,view: 'text', type: 'string',},
  telephone: {title: '电话',order: 6,view: 'text', type: 'string',},
  orderSourceId: {title: '来源渠道ID',order: 7,view: 'number', type: 'number',},
  orderSourceName: {title: '来源渠道名称',order: 8,view: 'text', type: 'string',},
  isPay: {title: '付款状态（0:未付 1:已付）',order: 9,view: 'number', type: 'number',},
  paymentMethods: {title: '平台支付方式',order: 10,view: 'text', type: 'string',},
  orderStatus: {title: '订单状态',order: 11,view: 'number', type: 'number',},
  orderState: {title: '订单发货状态',order: 12,view: 'number', type: 'number',},
  addTime: {title: '订单添加时间',order: 13,view: 'datetime', type: 'string',},
  payTime: {title: '订单支付时间',order: 14,view: 'datetime', type: 'string',},
  currency: {title: '订单使用币种',order: 15,view: 'text', type: 'string',},
  totalPrice: {title: '订单总金额',order: 16,view: 'number', type: 'number',},
  promotionDiscountAmount: {title: '优惠金额',order: 17,view: 'number', type: 'number',},
  transportPay: {title: '客户支付运费',order: 18,view: 'number', type: 'number',},
  country: {title: '收货人国家代码',order: 19,view: 'text', type: 'string',},
  province: {title: '收货人省份',order: 20,view: 'text', type: 'string',},
  city: {title: '收货人城市',order: 21,view: 'text', type: 'string',},
  companyName: {title: '公司名称',order: 22,view: 'text', type: 'string',},
  postCode: {title: '邮政编码',order: 23,view: 'text', type: 'string',},
  firstName: {title: '收货人名',order: 24,view: 'text', type: 'string',},
  lastName: {title: '收货人姓',order: 25,view: 'text', type: 'string',},
  address: {title: '完整地址',order: 26,view: 'text', type: 'string',},
  address1: {title: '地址行1',order: 27,view: 'text', type: 'string',},
  address2: {title: '地址行2',order: 28,view: 'text', type: 'string',},
  address3: {title: '地址行3',order: 29,view: 'text', type: 'string',},
  district: {title: '区县名称',order: 30,view: 'text', type: 'string',},
  cabinetNo: {title: '柜号',order: 31,view: 'text', type: 'string',},
  transportId: {title: '发货方式ID',order: 32,view: 'number', type: 'number',},
  transportName: {title: '发货方式名称',order: 33,view: 'text', type: 'string',},
  orderDescription: {title: '订单备注描述',order: 34,view: 'textarea', type: 'string',},
  isFbaOrder: {title: '是否FBA订单（0:否 1:是）',order: 35,view: 'number', type: 'number',},
  warehouseId: {title: '发货仓库ID',order: 36,view: 'number', type: 'number',},
  productWeight: {title: '订单总重量（克）',order: 37,view: 'number', type: 'number',},
  shipService: {title: '平台配送服务名称',order: 38,view: 'text', type: 'string',},
  trackNumbers: {title: '物流追踪号码',order: 39,view: 'text', type: 'string',},
  paypalFee: {title: 'Paypal手续费',order: 40,view: 'number', type: 'number',},
  refundPaypalFee: {title: '退款返还Paypal手续费',order: 41,view: 'number', type: 'number',},
  paypalTransactionFee: {title: 'Paypal交易手续费',order: 42,view: 'number', type: 'number',},
  paymentTypeName: {title: '支付方式名称',order: 43,view: 'text', type: 'string',},
  paymentTypeValue: {title: '支付方式代码',order: 44,view: 'number', type: 'number',},
  logisticsOrderNo: {title: '物流商单号',order: 45,view: 'text', type: 'string',},
  logisticsOrderNo1: {title: '物流商转单号',order: 46,view: 'text', type: 'string',},
  isStockOrder: {title: '是否备库订单（0:否 1:是）',order: 47,view: 'number', type: 'number',},
  shipmentId: {title: '亚马逊备库单ID',order: 48,view: 'text', type: 'string',},
  sellerOrderId: {title: '买家订单号',order: 49,view: 'text', type: 'string',},
  orderSourceType: {title: '订单来源渠道类型',order: 50,view: 'number', type: 'number',},
  shipTime: {title: '实际发货时间',order: 51,view: 'datetime', type: 'string',},
  encrypted: {title: '是否加密（0:未加密 1:已加密）',order: 52,view: 'number', type: 'number',},
  houseNumber: {title: '门牌号码',order: 53,view: 'text', type: 'string',},
  packagedIds: {title: '包裹IDs（多个用逗号分隔）',order: 54,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '系统SKU|产品编码',
    align:"center",
    dataIndex: 'sku'
   },
   {
    title: '自定义SKU',
    align:"center",
    dataIndex: 'clientSku'
   },
   {
    title: '产品英文名',
    align:"center",
    dataIndex: 'productName'
   },
   {
    title: '产品特点',
    align:"center",
    dataIndex: 'featureList'
   },
   {
    title: '包装清单',
    align:"center",
    dataIndex: 'packingList'
   },
   {
    title: '产品颜色属性',
    align:"center",
    dataIndex: 'productColor'
   },
   {
    title: '产品尺码属性',
    align:"center",
    dataIndex: 'productSize'
   },
   {
    title: '产品净重(g)',
    align:"center",
    dataIndex: 'netWeight'
   },
   {
    title: '产品毛重(g)',
    align:"center",
    dataIndex: 'grossWeight'
   },
   {
    title: '销售价',
    align:"center",
    dataIndex: 'salePrice'
   },
   {
    title: '库存数量',
    align:"center",
    dataIndex: 'goodNum'
   },
   {
    title: 'B2C页面Title',
    align:"center",
    dataIndex: 'pageTitle'
   },
   {
    title: 'B2C页面关键词描述',
    align:"center",
    dataIndex: 'mateDescription'
   },
   {
    title: 'B2C页面关键词',
    align:"center",
    dataIndex: 'mateKeyword'
   },
   {
    title: '搜索关键词',
    align:"center",
    dataIndex: 'searchKeyword'
   },
   {
    title: '产品报关名',
    align:"center",
    dataIndex: 'declarationName'
   },
   {
    title: '产品报关中文名',
    align:"center",
    dataIndex: 'declarationNameCn'
   },
   {
    title: '产品报关材质',
    align:"center",
    dataIndex: 'declarationMaterial'
   },
   {
    title: '产品报关价',
    align:"center",
    dataIndex: 'declarationPriceRate'
   },
   {
    title: '产品上架状态',
    align:"center",
    dataIndex: 'onlineStatus'
   },
   {
    title: '最新供货价',
    align:"center",
    dataIndex: 'lastSupplierPrice'
   },
   {
    title: '产品最新采购价',
    align:"center",
    dataIndex: 'lastBuyPrice'
   },
   {
    title: '产品单件采购运费',
    align:"center",
    dataIndex: 'unitShipFee'
   },
   {
    title: '产品长(cm)',
    align:"center",
    dataIndex: 'length'
   },
   {
    title: '产品宽(cm)',
    align:"center",
    dataIndex: 'width'
   },
   {
    title: '产品高(cm)',
    align:"center",
    dataIndex: 'height'
   },
   {
    title: '包装长(cm)',
    align:"center",
    dataIndex: 'packLength'
   },
   {
    title: '包装宽(cm)',
    align:"center",
    dataIndex: 'packWidth'
   },
   {
    title: '包装高(cm)',
    align:"center",
    dataIndex: 'packHeight'
   },
   {
    title: '侵权风险',
    align:"center",
    dataIndex: 'productProperty'
   },
   {
    title: '物流属性',
    align:"center",
    dataIndex: 'withBattery'
   },
   {
    title: '产品图片更新时间',
    align:"center",
    dataIndex: 'updateImageDateTime'
   },
   {
    title: '母体ID',
    align:"center",
    dataIndex: 'productGroupSku'
   },
   {
    title: '一级分类ID',
    align:"center",
    dataIndex: 'classId1'
   },
   {
    title: '二级分类ID',
    align:"center",
    dataIndex: 'classId2'
   },
   {
    title: '最后一级分类ID',
    align:"center",
    dataIndex: 'lastClassId'
   },
   {
    title: '完整英文分类',
    align:"center",
    dataIndex: 'fullClassNameEn'
   },
   {
    title: '产品中文名',
    align:"center",
    dataIndex: 'productNameCn'
   },
   {
    title: '上架时间',
    align:"center",
    dataIndex: 'onlineTime'
   },
   {
    title: '添加时间',
    align:"center",
    dataIndex: 'addTime'
   },
   {
    title: '开发人员',
    align:"center",
    dataIndex: 'developAdminName'
   },
   {
    title: '采购人员',
    align:"center",
    dataIndex: 'buyerName'
   },
   {
    title: '供应商',
    align:"center",
    dataIndex: 'supplierName'
   },
   {
    title: '供应商ID',
    align:"center",
    dataIndex: 'supplierId'
   },
   {
    title: '封面缩略图URL',
    align:"center",
    dataIndex: 'smallImageUrl'
   },
   {
    title: '产品来源',
    align:"center",
    dataIndex: 'comeSource'
   },
   {
    title: '开发类型',
    align:"center",
    dataIndex: 'developType'
   },
   {
    title: '图片来源',
    align:"center",
    dataIndex: 'pictureSource'
   },
   {
    title: '外箱长(cm)',
    align:"center",
    dataIndex: 'cartonLength'
   },
   {
    title: '外箱宽(cm)',
    align:"center",
    dataIndex: 'cartonWidth'
   },
   {
    title: '外箱高(cm)',
    align:"center",
    dataIndex: 'cartonHeight'
   },
   {
    title: '每箱数量',
    align:"center",
    dataIndex: 'cartonPcsNum'
   },
   {
    title: '整箱毛重(kg)',
    align:"center",
    dataIndex: 'cartonGrossWeight'
   },
   {
    title: '整箱净重(kg)',
    align:"center",
    dataIndex: 'cartonNetWeight'
   },
   {
    title: '产品状态',
    align:"center",
    dataIndex: 'productState'
   },
   {
    title: '采购链接',
    align:"center",
    dataIndex: 'webProductUrl'
   },
   {
    title: '开发审核状态',
    align:"center",
    dataIndex: 'developStatus'
   },
   {
    title: '编辑审核状态',
    align:"center",
    dataIndex: 'editStatus'
   },
   {
    title: '图片审核状态',
    align:"center",
    dataIndex: 'imageStatus'
   },
   {
    title: '终审状态',
    align:"center",
    dataIndex: 'checkStatus'
   },
   {
    title: '一级类目中文',
    align:"center",
    dataIndex: 'classNameCn1'
   },
   {
    title: '日均销量',
    align:"center",
    dataIndex: 'avgDailySales'
   },
   {
    title: '产品活跃度',
    align:"center",
    dataIndex: 'productVitalityType'
   },
   {
    title: '新品类型',
    align:"center",
    dataIndex: 'productNewType'
   },
   {
    title: '产品用途',
    align:"center",
    dataIndex: 'declarationPurpose'
   },
   {
    title: '图片处理人员',
    align:"center",
    dataIndex: 'imageAdminName'
   },
   {
    title: '产品编辑人员',
    align:"center",
    dataIndex: 'editAdminName'
   },
   {
    title: '海关编码',
    align:"center",
    dataIndex: 'declarationCode'
   },
   {
    title: '退税率',
    align:"center",
    dataIndex: 'taxRate'
   },
   {
    title: '包裹重量(kg)',
    align:"center",
    dataIndex: 'packWeight'
   },
   {
    title: '终审用户ID',
    align:"center",
    dataIndex: 'checkAdminId'
   },
   {
    title: '终审用户姓名',
    align:"center",
    dataIndex: 'checkAdminName'
   },
   {
    title: '开发备注',
    align:"center",
    dataIndex: 'toDevelopMemo'
   },
   {
    title: '禁售平台',
    align:"center",
    dataIndex: 'noSalePlatform'
   },
   {
    title: '品牌',
    align:"center",
    dataIndex: 'brandName'
   },
   {
    title: '是否组合产品',
    align:"center",
    dataIndex: 'isGroup'
   },
   {
    title: '规格型号',
    align:"center",
    dataIndex: 'productSpec'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '系统SKU|产品编码',
    field: 'sku',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入系统SKU|产品编码!'},
          ];
     },
  },
  {
    label: '自定义SKU',
    field: 'clientSku',
    component: 'Input',
  },
  {
    label: '产品英文名',
    field: 'productName',
    component: 'InputTextArea',
  },
  {
    label: '产品特点',
    field: 'featureList',
    component: 'InputTextArea',
  },
  {
    label: '包装清单',
    field: 'packingList',
    component: 'InputTextArea',
  },
  {
    label: '产品颜色属性',
    field: 'productColor',
    component: 'Input',
  },
  {
    label: '产品尺码属性',
    field: 'productSize',
    component: 'Input',
  },
  {
    label: '产品净重(g)',
    field: 'netWeight',
    component: 'InputNumber',
  },
  {
    label: '产品毛重(g)',
    field: 'grossWeight',
    component: 'InputNumber',
  },
  {
    label: '销售价',
    field: 'salePrice',
    component: 'InputNumber',
  },
  {
    label: '库存数量',
    field: 'goodNum',
    component: 'InputNumber',
  },
  {
    label: 'B2C页面Title',
    field: 'pageTitle',
    component: 'InputTextArea',
  },
  {
    label: 'B2C页面关键词描述',
    field: 'mateDescription',
    component: 'InputTextArea',
  },
  {
    label: 'B2C页面关键词',
    field: 'mateKeyword',
    component: 'InputTextArea',
  },
  {
    label: '搜索关键词',
    field: 'searchKeyword',
    component: 'InputTextArea',
  },
  {
    label: '产品报关名',
    field: 'declarationName',
    component: 'Input',
  },
  {
    label: '产品报关中文名',
    field: 'declarationNameCn',
    component: 'Input',
  },
  {
    label: '产品报关材质',
    field: 'declarationMaterial',
    component: 'Input',
  },
  {
    label: '产品报关价',
    field: 'declarationPriceRate',
    component: 'InputNumber',
  },
  {
    label: '产品上架状态',
    field: 'onlineStatus',
    component: 'Input',
  },
  {
    label: '最新供货价',
    field: 'lastSupplierPrice',
    component: 'InputNumber',
  },
  {
    label: '产品最新采购价',
    field: 'lastBuyPrice',
    component: 'InputNumber',
  },
  {
    label: '产品单件采购运费',
    field: 'unitShipFee',
    component: 'InputNumber',
  },
  {
    label: '产品长(cm)',
    field: 'length',
    component: 'InputNumber',
  },
  {
    label: '产品宽(cm)',
    field: 'width',
    component: 'InputNumber',
  },
  {
    label: '产品高(cm)',
    field: 'height',
    component: 'InputNumber',
  },
  {
    label: '包装长(cm)',
    field: 'packLength',
    component: 'InputNumber',
  },
  {
    label: '包装宽(cm)',
    field: 'packWidth',
    component: 'InputNumber',
  },
  {
    label: '包装高(cm)',
    field: 'packHeight',
    component: 'InputNumber',
  },
  {
    label: '侵权风险',
    field: 'productProperty',
    component: 'Input',
  },
  {
    label: '物流属性',
    field: 'withBattery',
    component: 'Input',
  },
  {
    label: '产品图片更新时间',
    field: 'updateImageDateTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '母体ID',
    field: 'productGroupSku',
    component: 'Input',
  },
  {
    label: '一级分类ID',
    field: 'classId1',
    component: 'InputNumber',
  },
  {
    label: '二级分类ID',
    field: 'classId2',
    component: 'InputNumber',
  },
  {
    label: '最后一级分类ID',
    field: 'lastClassId',
    component: 'InputNumber',
  },
  {
    label: '完整英文分类',
    field: 'fullClassNameEn',
    component: 'Input',
  },
  {
    label: '产品中文名',
    field: 'productNameCn',
    component: 'InputTextArea',
  },
  {
    label: '上架时间',
    field: 'onlineTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '添加时间',
    field: 'addTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '开发人员',
    field: 'developAdminName',
    component: 'Input',
  },
  {
    label: '采购人员',
    field: 'buyerName',
    component: 'Input',
  },
  {
    label: '供应商',
    field: 'supplierName',
    component: 'Input',
  },
  {
    label: '供应商ID',
    field: 'supplierId',
    component: 'InputNumber',
  },
  {
    label: '封面缩略图URL',
    field: 'smallImageUrl',
    component: 'InputTextArea',
  },
  {
    label: '产品来源',
    field: 'comeSource',
    component: 'Input',
  },
  {
    label: '开发类型',
    field: 'developType',
    component: 'Input',
  },
  {
    label: '图片来源',
    field: 'pictureSource',
    component: 'Input',
  },
  {
    label: '外箱长(cm)',
    field: 'cartonLength',
    component: 'InputNumber',
  },
  {
    label: '外箱宽(cm)',
    field: 'cartonWidth',
    component: 'InputNumber',
  },
  {
    label: '外箱高(cm)',
    field: 'cartonHeight',
    component: 'InputNumber',
  },
  {
    label: '每箱数量',
    field: 'cartonPcsNum',
    component: 'InputNumber',
  },
  {
    label: '整箱毛重(kg)',
    field: 'cartonGrossWeight',
    component: 'InputNumber',
  },
  {
    label: '整箱净重(kg)',
    field: 'cartonNetWeight',
    component: 'InputNumber',
  },
  {
    label: '产品状态',
    field: 'productState',
    component: 'Input',
  },
  {
    label: '采购链接',
    field: 'webProductUrl',
    component: 'InputTextArea',
  },
  {
    label: '开发审核状态',
    field: 'developStatus',
    component: 'Input',
  },
  {
    label: '编辑审核状态',
    field: 'editStatus',
    component: 'Input',
  },
  {
    label: '图片审核状态',
    field: 'imageStatus',
    component: 'Input',
  },
  {
    label: '终审状态',
    field: 'checkStatus',
    component: 'Input',
  },
  {
    label: '一级类目中文',
    field: 'classNameCn1',
    component: 'Input',
  },
  {
    label: '日均销量',
    field: 'avgDailySales',
    component: 'InputNumber',
  },
  {
    label: '产品活跃度',
    field: 'productVitalityType',
    component: 'Input',
  },
  {
    label: '新品类型',
    field: 'productNewType',
    component: 'Input',
  },
  {
    label: '产品用途',
    field: 'declarationPurpose',
    component: 'Input',
  },
  {
    label: '图片处理人员',
    field: 'imageAdminName',
    component: 'Input',
  },
  {
    label: '产品编辑人员',
    field: 'editAdminName',
    component: 'Input',
  },
  {
    label: '海关编码',
    field: 'declarationCode',
    component: 'Input',
  },
  {
    label: '退税率',
    field: 'taxRate',
    component: 'InputNumber',
  },
  {
    label: '包裹重量(kg)',
    field: 'packWeight',
    component: 'InputNumber',
  },
  {
    label: '终审用户ID',
    field: 'checkAdminId',
    component: 'InputNumber',
  },
  {
    label: '终审用户姓名',
    field: 'checkAdminName',
    component: 'Input',
  },
  {
    label: '开发备注',
    field: 'toDevelopMemo',
    component: 'InputTextArea',
  },
  {
    label: '禁售平台',
    field: 'noSalePlatform',
    component: 'Input',
  },
  {
    label: '品牌',
    field: 'brandName',
    component: 'Input',
  },
  {
    label: '是否组合产品',
    field: 'isGroup',
    component: 'InputNumber',
  },
  {
    label: '规格型号',
    field: 'productSpec',
    component: 'InputTextArea',
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
  sku: {title: '系统SKU|产品编码',order: 0,view: 'text', type: 'string',},
  clientSku: {title: '自定义SKU',order: 1,view: 'text', type: 'string',},
  productName: {title: '产品英文名',order: 2,view: 'textarea', type: 'string',},
  featureList: {title: '产品特点',order: 3,view: 'textarea', type: 'string',},
  packingList: {title: '包装清单',order: 4,view: 'textarea', type: 'string',},
  productColor: {title: '产品颜色属性',order: 5,view: 'text', type: 'string',},
  productSize: {title: '产品尺码属性',order: 6,view: 'text', type: 'string',},
  netWeight: {title: '产品净重(g)',order: 7,view: 'number', type: 'number',},
  grossWeight: {title: '产品毛重(g)',order: 8,view: 'number', type: 'number',},
  salePrice: {title: '销售价',order: 9,view: 'number', type: 'number',},
  goodNum: {title: '库存数量',order: 10,view: 'number', type: 'number',},
  pageTitle: {title: 'B2C页面Title',order: 11,view: 'textarea', type: 'string',},
  mateDescription: {title: 'B2C页面关键词描述',order: 12,view: 'textarea', type: 'string',},
  mateKeyword: {title: 'B2C页面关键词',order: 13,view: 'textarea', type: 'string',},
  searchKeyword: {title: '搜索关键词',order: 14,view: 'textarea', type: 'string',},
  declarationName: {title: '产品报关名',order: 15,view: 'text', type: 'string',},
  declarationNameCn: {title: '产品报关中文名',order: 16,view: 'text', type: 'string',},
  declarationMaterial: {title: '产品报关材质',order: 17,view: 'text', type: 'string',},
  declarationPriceRate: {title: '产品报关价',order: 18,view: 'number', type: 'number',},
  onlineStatus: {title: '产品上架状态',order: 19,view: 'text', type: 'string',},
  lastSupplierPrice: {title: '最新供货价',order: 20,view: 'number', type: 'number',},
  lastBuyPrice: {title: '产品最新采购价',order: 21,view: 'number', type: 'number',},
  unitShipFee: {title: '产品单件采购运费',order: 22,view: 'number', type: 'number',},
  length: {title: '产品长(cm)',order: 23,view: 'number', type: 'number',},
  width: {title: '产品宽(cm)',order: 24,view: 'number', type: 'number',},
  height: {title: '产品高(cm)',order: 25,view: 'number', type: 'number',},
  packLength: {title: '包装长(cm)',order: 26,view: 'number', type: 'number',},
  packWidth: {title: '包装宽(cm)',order: 27,view: 'number', type: 'number',},
  packHeight: {title: '包装高(cm)',order: 28,view: 'number', type: 'number',},
  productProperty: {title: '侵权风险',order: 29,view: 'text', type: 'string',},
  withBattery: {title: '物流属性',order: 30,view: 'text', type: 'string',},
  updateImageDateTime: {title: '产品图片更新时间',order: 31,view: 'datetime', type: 'string',},
  productGroupSku: {title: '母体ID',order: 32,view: 'text', type: 'string',},
  classId1: {title: '一级分类ID',order: 33,view: 'number', type: 'number',},
  classId2: {title: '二级分类ID',order: 34,view: 'number', type: 'number',},
  lastClassId: {title: '最后一级分类ID',order: 35,view: 'number', type: 'number',},
  fullClassNameEn: {title: '完整英文分类',order: 36,view: 'text', type: 'string',},
  productNameCn: {title: '产品中文名',order: 37,view: 'textarea', type: 'string',},
  onlineTime: {title: '上架时间',order: 38,view: 'datetime', type: 'string',},
  addTime: {title: '添加时间',order: 39,view: 'datetime', type: 'string',},
  developAdminName: {title: '开发人员',order: 40,view: 'text', type: 'string',},
  buyerName: {title: '采购人员',order: 41,view: 'text', type: 'string',},
  supplierName: {title: '供应商',order: 42,view: 'text', type: 'string',},
  supplierId: {title: '供应商ID',order: 43,view: 'number', type: 'number',},
  smallImageUrl: {title: '封面缩略图URL',order: 44,view: 'textarea', type: 'string',},
  comeSource: {title: '产品来源',order: 45,view: 'text', type: 'string',},
  developType: {title: '开发类型',order: 46,view: 'text', type: 'string',},
  pictureSource: {title: '图片来源',order: 47,view: 'text', type: 'string',},
  cartonLength: {title: '外箱长(cm)',order: 48,view: 'number', type: 'number',},
  cartonWidth: {title: '外箱宽(cm)',order: 49,view: 'number', type: 'number',},
  cartonHeight: {title: '外箱高(cm)',order: 50,view: 'number', type: 'number',},
  cartonPcsNum: {title: '每箱数量',order: 51,view: 'number', type: 'number',},
  cartonGrossWeight: {title: '整箱毛重(kg)',order: 52,view: 'number', type: 'number',},
  cartonNetWeight: {title: '整箱净重(kg)',order: 53,view: 'number', type: 'number',},
  productState: {title: '产品状态',order: 54,view: 'text', type: 'string',},
  webProductUrl: {title: '采购链接',order: 55,view: 'textarea', type: 'string',},
  developStatus: {title: '开发审核状态',order: 56,view: 'text', type: 'string',},
  editStatus: {title: '编辑审核状态',order: 57,view: 'text', type: 'string',},
  imageStatus: {title: '图片审核状态',order: 58,view: 'text', type: 'string',},
  checkStatus: {title: '终审状态',order: 59,view: 'text', type: 'string',},
  classNameCn1: {title: '一级类目中文',order: 60,view: 'text', type: 'string',},
  avgDailySales: {title: '日均销量',order: 61,view: 'number', type: 'number',},
  productVitalityType: {title: '产品活跃度',order: 62,view: 'text', type: 'string',},
  productNewType: {title: '新品类型',order: 63,view: 'text', type: 'string',},
  declarationPurpose: {title: '产品用途',order: 64,view: 'text', type: 'string',},
  imageAdminName: {title: '图片处理人员',order: 65,view: 'text', type: 'string',},
  editAdminName: {title: '产品编辑人员',order: 66,view: 'text', type: 'string',},
  declarationCode: {title: '海关编码',order: 67,view: 'text', type: 'string',},
  taxRate: {title: '退税率',order: 68,view: 'number', type: 'number',},
  packWeight: {title: '包裹重量(kg)',order: 69,view: 'number', type: 'number',},
  checkAdminId: {title: '终审用户ID',order: 70,view: 'number', type: 'number',},
  checkAdminName: {title: '终审用户姓名',order: 71,view: 'text', type: 'string',},
  toDevelopMemo: {title: '开发备注',order: 72,view: 'textarea', type: 'string',},
  noSalePlatform: {title: '禁售平台',order: 73,view: 'text', type: 'string',},
  brandName: {title: '品牌',order: 74,view: 'text', type: 'string',},
  isGroup: {title: '是否组合产品',order: 75,view: 'number', type: 'number',},
  productSpec: {title: '规格型号',order: 76,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
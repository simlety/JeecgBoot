<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">ldw_orders</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">系统订单号（业务唯一标识）：</text></view>
                  <input  placeholder="请输入系统订单号（业务唯一标识）" v-model="model.orderCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平台订单号：</text></view>
                  <input  placeholder="请输入平台订单号" v-model="model.clientOrderCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">Ebay订单号：</text></view>
                  <input type="number" placeholder="请输入Ebay订单号" v-model="model.salesRecordNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">交易号：</text></view>
                  <input  placeholder="请输入交易号" v-model="model.transactionId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">客户ID：</text></view>
                  <input  placeholder="请输入客户ID" v-model="model.clientUserAccount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">邮箱：</text></view>
                  <input  placeholder="请输入邮箱" v-model="model.email"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">电话：</text></view>
                  <input  placeholder="请输入电话" v-model="model.telephone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">来源渠道ID：</text></view>
                  <input type="number" placeholder="请输入来源渠道ID" v-model="model.orderSourceId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">来源渠道名称：</text></view>
                  <input  placeholder="请输入来源渠道名称" v-model="model.orderSourceName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">付款状态（0:未付 1:已付）：</text></view>
                  <input type="number" placeholder="请输入付款状态（0:未付 1:已付）" v-model="model.isPay"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平台支付方式：</text></view>
                  <input  placeholder="请输入平台支付方式" v-model="model.paymentMethods"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单状态：</text></view>
                  <input type="number" placeholder="请输入订单状态" v-model="model.orderStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单发货状态：</text></view>
                  <input type="number" placeholder="请输入订单发货状态" v-model="model.orderState"/>
                </view>
              </view>
              <my-date label="订单添加时间：" v-model="model.addTime" placeholder="请输入订单添加时间"></my-date>
              <my-date label="订单支付时间：" v-model="model.payTime" placeholder="请输入订单支付时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单使用币种：</text></view>
                  <input  placeholder="请输入订单使用币种" v-model="model.currency"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单总金额：</text></view>
                  <input type="number" placeholder="请输入订单总金额" v-model="model.totalPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">优惠金额：</text></view>
                  <input type="number" placeholder="请输入优惠金额" v-model="model.promotionDiscountAmount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">客户支付运费：</text></view>
                  <input type="number" placeholder="请输入客户支付运费" v-model="model.transportPay"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">收货人国家代码：</text></view>
                  <input  placeholder="请输入收货人国家代码" v-model="model.country"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">收货人省份：</text></view>
                  <input  placeholder="请输入收货人省份" v-model="model.province"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">收货人城市：</text></view>
                  <input  placeholder="请输入收货人城市" v-model="model.city"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">公司名称：</text></view>
                  <input  placeholder="请输入公司名称" v-model="model.companyName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">邮政编码：</text></view>
                  <input  placeholder="请输入邮政编码" v-model="model.postCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">收货人名：</text></view>
                  <input  placeholder="请输入收货人名" v-model="model.firstName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">收货人姓：</text></view>
                  <input  placeholder="请输入收货人姓" v-model="model.lastName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">完整地址：</text></view>
                  <input  placeholder="请输入完整地址" v-model="model.address"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">地址行1：</text></view>
                  <input  placeholder="请输入地址行1" v-model="model.address1"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">地址行2：</text></view>
                  <input  placeholder="请输入地址行2" v-model="model.address2"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">地址行3：</text></view>
                  <input  placeholder="请输入地址行3" v-model="model.address3"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">区县名称：</text></view>
                  <input  placeholder="请输入区县名称" v-model="model.district"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">柜号：</text></view>
                  <input  placeholder="请输入柜号" v-model="model.cabinetNo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">发货方式ID：</text></view>
                  <input type="number" placeholder="请输入发货方式ID" v-model="model.transportId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">发货方式名称：</text></view>
                  <input  placeholder="请输入发货方式名称" v-model="model.transportName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单备注描述：</text></view>
                  <input  placeholder="请输入订单备注描述" v-model="model.orderDescription"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否FBA订单（0:否 1:是）：</text></view>
                  <input type="number" placeholder="请输入是否FBA订单（0:否 1:是）" v-model="model.isFbaOrder"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">发货仓库ID：</text></view>
                  <input type="number" placeholder="请输入发货仓库ID" v-model="model.warehouseId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单总重量（克）：</text></view>
                  <input type="number" placeholder="请输入订单总重量（克）" v-model="model.productWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平台配送服务名称：</text></view>
                  <input  placeholder="请输入平台配送服务名称" v-model="model.shipService"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">物流追踪号码：</text></view>
                  <input  placeholder="请输入物流追踪号码" v-model="model.trackNumbers"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">Paypal手续费：</text></view>
                  <input type="number" placeholder="请输入Paypal手续费" v-model="model.paypalFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">退款返还Paypal手续费：</text></view>
                  <input type="number" placeholder="请输入退款返还Paypal手续费" v-model="model.refundPaypalFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">Paypal交易手续费：</text></view>
                  <input type="number" placeholder="请输入Paypal交易手续费" v-model="model.paypalTransactionFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">支付方式名称：</text></view>
                  <input  placeholder="请输入支付方式名称" v-model="model.paymentTypeName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">支付方式代码：</text></view>
                  <input type="number" placeholder="请输入支付方式代码" v-model="model.paymentTypeValue"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">物流商单号：</text></view>
                  <input  placeholder="请输入物流商单号" v-model="model.logisticsOrderNo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">物流商转单号：</text></view>
                  <input  placeholder="请输入物流商转单号" v-model="model.logisticsOrderNo1"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否备库订单（0:否 1:是）：</text></view>
                  <input type="number" placeholder="请输入是否备库订单（0:否 1:是）" v-model="model.isStockOrder"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">亚马逊备库单ID：</text></view>
                  <input  placeholder="请输入亚马逊备库单ID" v-model="model.shipmentId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">买家订单号：</text></view>
                  <input  placeholder="请输入买家订单号" v-model="model.sellerOrderId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">订单来源渠道类型：</text></view>
                  <input type="number" placeholder="请输入订单来源渠道类型" v-model="model.orderSourceType"/>
                </view>
              </view>
              <my-date label="实际发货时间：" v-model="model.shipTime" placeholder="请输入实际发货时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否加密（0:未加密 1:已加密）：</text></view>
                  <input type="number" placeholder="请输入是否加密（0:未加密 1:已加密）" v-model="model.encrypted"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">门牌号码：</text></view>
                  <input  placeholder="请输入门牌号码" v-model="model.houseNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">包裹IDs（多个用逗号分隔）：</text></view>
                  <input  placeholder="请输入包裹IDs（多个用逗号分隔）" v-model="model.packagedIds"/>
                </view>
              </view>
				<view class="padding">
					<button class="cu-btn block bg-blue margin-tb-sm lg" @click="onSubmit">
						<text v-if="loading" class="cuIcon-loading2 cuIconfont-spin"></text>提交
					</button>
				</view>
			</form>
		</view>
    </view>
</template>

<script>
    import myDate from '@/components/my-componets/my-date.vue'

    export default {
        name: "LdwOrdersForm",
        components:{ myDate },
        props:{
          formData:{
              type:Object,
              default:()=>{},
              required:false
          }
        },
        data(){
            return {
				CustomBar: this.CustomBar,
				NavBarColor: this.NavBarColor,
				loading:false,
                model: {},
                backRouteName:'index',
                url: {
                  queryById: "/ldw/ldwOrders/queryById",
                  add: "/ldw/ldwOrders/add",
                  edit: "/ldw/ldwOrders/edit",
                },
            }
        },
        created(){
             this.initFormData();
        },
        methods:{
           initFormData(){
               if(this.formData){
                    let dataId = this.formData.dataId;
                    this.$http.get(this.url.queryById,{params:{id:dataId}}).then((res)=>{
                        if(res.data.success){
                            console.log("表单数据",res);
                            this.model = res.data.result;
                        }
                    })
                }
            },
            onSubmit() {
                let myForm = {...this.model};
                this.loading = true;
                let url = myForm.id?this.url.edit:this.url.add;
				this.$http.post(url,myForm).then(res=>{
				   console.log("res",res)
				   this.loading = false
				   this.$Router.push({name:this.backRouteName})
				}).catch(()=>{
					this.loading = false
				});
            }
        }
    }
</script>

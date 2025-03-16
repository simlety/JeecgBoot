<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">ldw_order_items</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">关联订单ID：</text></view>
                  <input type="number" placeholder="请输入关联订单ID" v-model="model.orderId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">冗余订单号（用于快速查询）：</text></view>
                  <input  placeholder="请输入冗余订单号（用于快速查询）" v-model="model.orderCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">系统SKU编号：</text></view>
                  <input  placeholder="请输入系统SKU编号" v-model="model.sku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">客户自定义SKU：</text></view>
                  <input  placeholder="请输入客户自定义SKU" v-model="model.clientSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">组合产品SKU：</text></view>
                  <input  placeholder="请输入组合产品SKU" v-model="model.groupSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">组合产品客户SKU：</text></view>
                  <input  placeholder="请输入组合产品客户SKU" v-model="model.groupClientSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">组合产品数量：</text></view>
                  <input type="number" placeholder="请输入组合产品数量" v-model="model.groupProductNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">组合产品售价：</text></view>
                  <input type="number" placeholder="请输入组合产品售价" v-model="model.groupProductPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品数量：</text></view>
                  <input type="number" placeholder="请输入产品数量" v-model="model.productNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品单价：</text></view>
                  <input type="number" placeholder="请输入产品单价" v-model="model.productPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">运费收入：</text></view>
                  <input type="number" placeholder="请输入运费收入" v-model="model.shippingPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最新采购价（人民币）：</text></view>
                  <input type="number" placeholder="请输入最新采购价（人民币）" v-model="model.lastBuyPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">供应商报价（人民币）：</text></view>
                  <input type="number" placeholder="请输入供应商报价（人民币）" v-model="model.lastSupplierPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">头程运费（人民币）：</text></view>
                  <input type="number" placeholder="请输入头程运费（人民币）" v-model="model.firstLegFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">进口关税（人民币）：</text></view>
                  <input type="number" placeholder="请输入进口关税（人民币）" v-model="model.tariffFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平台渠道SKU：</text></view>
                  <input  placeholder="请输入平台渠道SKU" v-model="model.sellerSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平台商品项ID：</text></view>
                  <input  placeholder="请输入平台商品项ID" v-model="model.orderItemId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">亚马逊标准识别号：</text></view>
                  <input  placeholder="请输入亚马逊标准识别号" v-model="model.asin"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品规格参数：</text></view>
                  <input  placeholder="请输入商品规格参数" v-model="model.parameterValues"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品标题：</text></view>
                  <input  placeholder="请输入商品标题" v-model="model.itemTitle"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否生成包裹（0:否 1:是）：</text></view>
                  <input type="number" placeholder="请输入是否生成包裹（0:否 1:是）" v-model="model.isBuildPackage"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品重量（克）：</text></view>
                  <input type="number" placeholder="请输入商品重量（克）" v-model="model.productWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品长度（厘米）：</text></view>
                  <input type="number" placeholder="请输入商品长度（厘米）" v-model="model.productLength"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品宽度（厘米）：</text></view>
                  <input type="number" placeholder="请输入商品宽度（厘米）" v-model="model.productWidth"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品高度（厘米）：</text></view>
                  <input type="number" placeholder="请输入商品高度（厘米）" v-model="model.productHeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销售人员ID：</text></view>
                  <input type="number" placeholder="请输入销售人员ID" v-model="model.businessAdminId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销售人员英文名：</text></view>
                  <input  placeholder="请输入销售人员英文名" v-model="model.businessAdminNameEn"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销售人员姓名：</text></view>
                  <input  placeholder="请输入销售人员姓名" v-model="model.businessAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发人员ID：</text></view>
                  <input type="number" placeholder="请输入开发人员ID" v-model="model.developAdminId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发人员英文名：</text></view>
                  <input  placeholder="请输入开发人员英文名" v-model="model.developAdminNameEn"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发人员姓名：</text></view>
                  <input  placeholder="请输入开发人员姓名" v-model="model.developAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品详情页链接：</text></view>
                  <input  placeholder="请输入商品详情页链接" v-model="model.productLinks"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最新成本价：</text></view>
                  <input type="number" placeholder="请输入最新成本价" v-model="model.productLatestCost"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品净重（克）：</text></view>
                  <input type="number" placeholder="请输入商品净重（克）" v-model="model.netWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品税费：</text></view>
                  <input type="number" placeholder="请输入商品税费" v-model="model.itemTax"/>
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
        name: "LdwOrderItemsForm",
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
                  queryById: "/ldw/ldwOrderItems/queryById",
                  add: "/ldw/ldwOrderItems/add",
                  edit: "/ldw/ldwOrderItems/edit",
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

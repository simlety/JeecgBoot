<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">ldw_ebay_listings</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">业务系统原始ID（需保持唯一性）：</text></view>
                  <input type="number" placeholder="请输入业务系统原始ID（需保持唯一性）" v-model="model.listingBasicId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">来源渠道ID（关联渠道配置表）：</text></view>
                  <input type="number" placeholder="请输入来源渠道ID（关联渠道配置表）" v-model="model.orderSourceId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">渠道名称（如eBay德国站）：</text></view>
                  <input  placeholder="请输入渠道名称（如eBay德国站）" v-model="model.orderSourceName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">系统SKU（最大长度50字符，唯一商品编码）：</text></view>
                  <input  placeholder="请输入系统SKU（最大长度50字符，唯一商品编码）" v-model="model.sku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">渠道SKU（平台侧商品编码，最大长度100）：</text></view>
                  <input  placeholder="请输入渠道SKU（平台侧商品编码，最大长度100）" v-model="model.orderSourceSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">平台商品ID（eBay API返回的ItemID）：</text></view>
                  <input  placeholder="请输入平台商品ID（eBay API返回的ItemID）" v-model="model.itemId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品标题（德语，最大长度500字符）：</text></view>
                  <input  placeholder="请输入商品标题（德语，最大长度500字符）" v-model="model.productTitle"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">站点代码（遵循eBay站点编码规范，如DE）：</text></view>
                  <input  placeholder="请输入站点代码（遵循eBay站点编码规范，如DE）" v-model="model.siteCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">主分类（平台分类体系一级类目）：</text></view>
                  <input  placeholder="请输入主分类（平台分类体系一级类目）" v-model="model.primaryCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">二级分类（平台分类体系二级类目）：</text></view>
                  <input  placeholder="请输入二级分类（平台分类体系二级类目）" v-model="model.secondaryCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">完整分类路径（平台分类全路径，分隔符:）：</text></view>
                  <input  placeholder="请输入完整分类路径（平台分类全路径，分隔符:）" v-model="model.allCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">一级产品类目（内部产品类目体系）：</text></view>
                  <input  placeholder="请输入一级产品类目（内部产品类目体系）" v-model="model.primaryProductCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">二级产品类目（内部产品类目体系）：</text></view>
                  <input  placeholder="请输入二级产品类目（内部产品类目体系）" v-model="model.secondaryProductCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">三级产品类目（内部产品类目体系）：</text></view>
                  <input  placeholder="请输入三级产品类目（内部产品类目体系）" v-model="model.threeProductCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">完整产品类目路径（内部分类全路径）：</text></view>
                  <input  placeholder="请输入完整产品类目路径（内部分类全路径）" v-model="model.allProductCategory"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">中文产品名称（最大长度300字符）：</text></view>
                  <input  placeholder="请输入中文产品名称（最大长度300字符）" v-model="model.productNameCn"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销售价格（含小数点精度，最大9999999999.99）：</text></view>
                  <input type="number" placeholder="请输入销售价格（含小数点精度，最大9999999999.99）" v-model="model.sellingPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">货币代码（ISO 4217标准，如EUR/USD）：</text></view>
                  <input  placeholder="请输入货币代码（ISO 4217标准，如EUR/USD）" v-model="model.currency"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">周销量（自然周统计，自动更新）：</text></view>
                  <input type="number" placeholder="请输入周销量（自然周统计，自动更新）" v-model="model.salesWeek"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">两周销量（滚动统计周期）：</text></view>
                  <input type="number" placeholder="请输入两周销量（滚动统计周期）" v-model="model.salesTwoWeek"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">月销量（自然月统计）：</text></view>
                  <input type="number" placeholder="请输入月销量（自然月统计）" v-model="model.salesMonth"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">三月销量（季度滚动统计）：</text></view>
                  <input type="number" placeholder="请输入三月销量（季度滚动统计）" v-model="model.salesThreeMonth"/>
                </view>
              </view>
              <my-date label="上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）：" v-model="model.onSelfTime" placeholder="请输入上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）"></my-date>
              <my-date label="下架时间（UTC时区，自动记录）：" v-model="model.soldOutTime" placeholder="请输入下架时间（UTC时区，自动记录）"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">添加人（员工账号名称，AD账号）：</text></view>
                  <input  placeholder="请输入添加人（员工账号名称，AD账号）" v-model="model.addItemAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">业务团队（事业部名称，如3C事业部）：</text></view>
                  <input  placeholder="请输入业务团队（事业部名称，如3C事业部）" v-model="model.businessTeamName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">刊登费用（平台服务费，货币与currency字段一致）：</text></view>
                  <input type="number" placeholder="请输入刊登费用（平台服务费，货币与currency字段一致）" v-model="model.addItemFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架：</text></view>
                  <input type="number" placeholder="请输入在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架" v-model="model.status"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品链接（平台商品详情页URL）：</text></view>
                  <input  placeholder="请输入商品链接（平台商品详情页URL）" v-model="model.productSellLink"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">变体状态：0-无变体 1-父变体 2-子变体 3-变体异常：</text></view>
                  <input type="number" placeholder="请输入变体状态：0-无变体 1-父变体 2-子变体 3-变体异常" v-model="model.variationStatus"/>
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
        name: "LdwEbayListingsForm",
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
                  queryById: "/ldw/ldwEbayListings/queryById",
                  add: "/ldw/ldwEbayListings/add",
                  edit: "/ldw/ldwEbayListings/edit",
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

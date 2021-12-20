/*
jQWidgets v12.2.0 (2021-Sep)
Copyright (c) 2011-2021 jQWidgets.
License: https://jqwidgets.com/license/
*/
/* eslint-disable */

(function(a){a.extend(a.jqx._jqxGrid.prototype,{_calculateaggregate:function(g,j,h,c){var f=g.aggregates;if(!f){f=j}if(f){var e=new Array();for(var d=0;d<f.length;d++){if(f[d]=="count"){continue}e[e.length]=g.cellsformat}if(this.source&&this.source.getAggregatedData){if(c==undefined){c=this.getrows()}if(this.virtualmode){var c=new Array();a.each(this.source._source.records,function(){c.push(this)})}if(h==undefined||h==true){var b=this.source.getAggregatedData([{name:g.datafield,aggregates:f,formatStrings:e}],this.gridlocalization,c);return b}else{var b=this.source.getAggregatedData([{name:g.datafield,aggregates:f}],this.gridlocalization,c);return b}}}return null},getcolumnaggregateddata:function(c,g,h,d){var e=this.getcolumn(c);var j=(h==undefined||h==false)?false:h;if(g==null){return""}var b=e.aggregates;e.aggregates=null;var i=this._calculateaggregate(e,g,j,d);var f={};if(i){f=i[c]}e.aggregates=b;return f},refreshaggregates:function(){this._updatecolumnsaggregates()},renderaggregates:function(){this._updateaggregates()},_updatecolumnaggregates:function(d,g,b){var e=this;if(!g){b.children().remove();b.html("");if(d.aggregatesrenderer){var f={};if(d.aggregates){f=this.getcolumnaggregateddata(d.datafield,d.aggregates)}var c=d.aggregatesrenderer({},d,b,null);b.html(c)}return}b.children().remove();b.html("");if(d.aggregatesrenderer){if(g){var c=d.aggregatesrenderer(g[d.datafield],d,b,this.getcolumnaggregateddata(d.datafield,g[d.datafield]));b.html(c)}}else{a.each(g,function(){var i=this;for(f in i){var j=a('<div style="position: relative; margin: 4px; overflow: hidden;"></div>');var h=f;h=e._getaggregatename(h);j.html(h+" "+i[f]);if(e.rtl){j.addClass(e.toThemeProperty("jqx-rtl"))}b.append(j)}})}},_getaggregatetype:function(c){switch(c){case"min":case"max":case"count":case"avg":case"product":case"var":case"varp":case"stdev":case"stdevp":case"sum":return c}var b=c;for(var d in c){b=d;break}return b},_getaggregatename:function(c){var b=c;switch(c){case"min":b="Min";break;case"max":b="Max";break;case"count":b="Count";break;case"avg":b="Avg";break;case"product":b="Product";break;case"var":b="Var";break;case"stdevp":b="StDevP";break;case"stdev":b="StDev";break;case"varp":b="VarP";case"sum":b=" ";break}if(c===b&&typeof(b)!="string"){for(var d in c){b=d;break}}return b},_updatecolumnsaggregates:function(){var f=this.getrows();var b=this.columns.records.length;if(undefined!=this.statusbar[0].cells){for(var e=0;e<b;e++){var g=a(this.statusbar[0].cells[e]);var d=this.columns.records[e];var c=this._calculateaggregate(d,null,true,f);this._updatecolumnaggregates(d,c,g)}}},_updateaggregates:function(){var b=a('<div style="position: relative;" id="statusrow'+this.element.id+'"></div>');var f=0;var l=this.columns.records.length;var k=this.toThemeProperty("jqx-grid-cell");if(this.rtl){k+=" "+this.toThemeProperty("jqx-grid-cell-rtl");f=-1}k+=" "+this.toThemeProperty("jqx-grid-cell-pinned");var m=l+10;var n=new Array();this.statusbar[0].cells=n;var o=this.getrows();for(var g=0;g<l;g++){var e=this.columns.records[g];var h=this._calculateaggregate(e,e.aggregates,true,o);var c=e.width;if(c<e.minwidth){c=e.minwidth}if(c>e.maxwidth){c=e.maxwidth}var d=k;if(e.cellsalign){d+=" "+this.toThemeProperty("jqx-"+e.cellsalign+"-align")}var i=a('<div style="overflow: hidden; position: absolute; height: 100%;" class="'+d+'"></div>');b.append(i);i.css("left",f);if(!this.rtl){i.css("z-index",m--)}else{i.css("z-index",m++)}i.width(c);i[0].left=f;if(!(e.hidden&&e.hideable)){f+=c}else{i.css("display","none")}n[n.length]=i[0];this._updatecolumnaggregates(e,h,i)}if(a.jqx.browser.msie&&a.jqx.browser.version<8){b.css("z-index",m--)}b.width(parseFloat(f)+2);b.height(this.statusbarheight);this.statusbar.children().remove();this.statusbar.append(b);this.statusbar.removeClass(this.toThemeProperty("jqx-widget-header"));this.statusbar.addClass(k);this.statusbar.css("border-bottom-color","transparent");this.statusbar.css("border-top-width","1px");if(this.rtl&&this.hScrollBar.css("visibility")!="hidden"){this._renderhorizontalscroll()}this._arrange()}})})(jqxBaseFramework);


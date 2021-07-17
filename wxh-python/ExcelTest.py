import xlwt

book = xlwt.Workbook(encoding='utf-8')
sheet = book.add_sheet('sheetname')


def set_style(color='white', height=260, bold=False):

    #： 设置单元格字体
    style = xlwt.XFStyle()
    font = xlwt.Font()
    # font.name = name
    font.bold = bold
    font.color_index = 4
    font.height = height
    style.font = font

    # 设置单元格背景颜色
    pattern = xlwt.Pattern()
    pattern.pattern = xlwt.Pattern.SOLID_PATTERN
    pattern.pattern_fore_colour = xlwt.Style.colour_map[color]
    style.pattern = pattern

    #:设置单元格边框线条
    borders = xlwt.Borders()  # Create Borders
    # May be: NO_LINE, THIN, MEDIUM, DASHED, DOTTED, THICK, DOUBLE, HAIR,
    # MEDIUM_DASHED, THIN_DASH_DOTTED, MEDIUM_DASH_DOTTED,
    # THIN_DASH_DOT_DOTTED, MEDIUM_DASH_DOT_DOTTED,
    # SLANTED_MEDIUM_DASH_DOTTED, or 0x00 through 0x0D.
    borders.left = xlwt.Borders.THIN
    borders.right = xlwt.Borders.THIN
    borders.top = xlwt.Borders.THIN
    borders.bottom = xlwt.Borders.THIN
    style.borders = borders  # Add Borders to Style

    #： 设置单元格居中格式
    alignment = xlwt.Alignment()  # Create Alignment
    # May be: HORZ_GENERAL, HORZ_LEFT, HORZ_CENTER, HORZ_RIGHT, HORZ_FILLED,
    # HORZ_JUSTIFIED, HORZ_CENTER_ACROSS_SEL, HORZ_DISTRIBUTED
    alignment.horz = xlwt.Alignment.HORZ_CENTER  # 横向居中
    alignment.vert = xlwt.Alignment.VERT_CENTER  # 纵向居中  May be: VERT_TOP, VERT_CENTER, VERT_BOTTOM, VERT_JUSTIFIED, VERT_DISTRIBUTED
    alignment.wrap = xlwt.Alignment.WRAP_AT_RIGHT  # ：自动换行
    style.alignment = alignment
    return style

#：模拟数据
data = [
    {
        "goal_id": 17,
        "goal_name": "\u5b9e\u73b0OKR\u4e0e\u4efb\u52a1\u7ba1\u7406\u7cfb\u7edf\u4e0a\u7ebf\u4e14\u672c\u7ec4\u5185\u65e5\u5e38\u5316\u4f7f\u7528",
        "goal_progress": 0,
        "name": "\u589e\u52a0\u76ee\u6807\u3001\u4efb\u52a1\u7684\u5ef6\u671f\u63d0\u9192\u4e0e\u5c55\u793a\u3002",
        "owner": "aaron.yang",
        "progress": 0,
        "result_id": 26,
        "result_name": "\u5b8c\u6210\u4efb\u52a1\u3001OKR\u3001\u62a5\u8868\u3001\u7ee9\u6548\u529f\u80fd\u6a21\u5757\u5f00\u53d1\u4e0e\u4e0a\u7ebf",
        "result_progress": 0,
    },
    {
        "goal_id": 17,
        "goal_name": "\u5b9e\u73b0OKR\u4e0e\u4efb\u52a1\u7ba1\u7406\u7cfb\u7edf\u4e0a\u7ebf\u4e14\u672c\u7ec4\u5185\u65e5\u5e38\u5316\u4f7f\u7528",
        "goal_progress": 0,
        "name": "task2",
        "owner": "aaron.yang",
        "progress": 0,
        "result_id": 26,
        "result_name": "\u5b8c\u6210\u4efb\u52a1\u3001OKR\u3001\u62a5\u8868\u3001\u7ee9\u6548\u529f\u80fd\u6a21\u5757\u5f00\u53d1\u4e0e\u4e0a\u7ebf",
        "result_progress": 0,
    },
    {
        "goal_id": 17,
        "goal_name": "\u5b9e\u73b0OKR\u4e0e\u4efb\u52a1\u7ba1\u7406\u7cfb\u7edf\u4e0a\u7ebf\u4e14\u672c\u7ec4\u5185\u65e5\u5e38\u5316\u4f7f\u7528",
        "goal_progress": 0,
        "name": "task3",
        "owner": "aaron.yang",
        "progress": 0,
        "result_id": 26,
        "result_name": "\u5b8c\u6210\u4efb\u52a1\u3001OKR\u3001\u62a5\u8868\u3001\u7ee9\u6548\u529f\u80fd\u6a21\u5757\u5f00\u53d1\u4e0e\u4e0a\u7ebf",
        "result_progress": 0,
    },
]
# 写入第一行数据
row0 = ['目标名称', '目标进度', '关键结果名称', '关键结果进度', '任务名称', '任务负责人', '任务进度']
sheet.write_merge(0, 0, 0, 3, 'OKR', set_style('purple_ega', height=500))
sheet.write_merge(0, 0, 4, 6, '任务', set_style('cyan_ega', height=500))

# 写入第二行数据
for i in range(0, len(row0)):
    sheet.write(1, i, row0[i], set_style('sky_blue'))

# 把需要合并的单元格，统计要合并多少行，以key,value形式缓存起来。
goal_tmp = {}
result_tmp = {}
for task in data:
    if task['goal_id'] not in goal_tmp:
        goal_tmp[task['goal_id']] = 1
    else:
        goal_tmp[task['goal_id']] += 1

    if task['result_id'] not in result_tmp:
        result_tmp[task['result_id']] = 1
    else:
        result_tmp[task['result_id']] += 1

goal_ids = []
result_ids = []
for index, task in enumerate(data):
    index = index + 1
    row_start = 1 + index
    #： 如果已合并单元格，把id追加到列表，避免重复合并
    if task['goal_id'] not in goal_ids:
        row_end = index + goal_tmp[task['goal_id']]
        sheet.write_merge(row_start, row_end, 0, 0, task['goal_name'], set_style())
        sheet.write_merge(row_start, row_end, 1, 1, task['goal_progress'], set_style())
        goal_ids.append(task['goal_id'])
    if task['result_id'] not in result_ids:
        row_end = index + result_tmp[task['result_id']]
        sheet.write_merge(row_start, row_end, 2, 2, task['result_name'], set_style())
        sheet.write_merge(row_start, row_end, 3, 3, task['result_progress'], set_style('yellow'))
        result_ids.append(task['result_id'])

    # 写入接下来的几列数据，并根据关键的列设置背景颜色
    sheet.write(row_start, 4, task['name'], set_style())
    sheet.write(row_start, 5, task['owner'], set_style())
    sheet.write(row_start, 6, task['progress'], set_style('yellow'))

#： 设置单元格宽度
sheet.col(0).width = 10000
sheet.col(2).width = 10000
sheet.col(3).width = 4000
sheet.col(4).width = 10000
sheet.col(5).width = 5000
#：写入到文件
book.save('/Users/weixuhui/git/Test/wxh-python/tmp/bookname.xls')
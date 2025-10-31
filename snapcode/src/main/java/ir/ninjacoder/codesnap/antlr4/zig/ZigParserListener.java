// Generated from /storage/emulated/0/cdm/ZigParser.g4 by ANTLR 4.13.2
package ir.ninjacoder.codesnap.antlr4.zig;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZigParser}.
 */
public interface ZigParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZigParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(ZigParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(ZigParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#container_members}.
	 * @param ctx the parse tree
	 */
	void enterContainer_members(ZigParser.Container_membersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#container_members}.
	 * @param ctx the parse tree
	 */
	void exitContainer_members(ZigParser.Container_membersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#container_declaration}.
	 * @param ctx the parse tree
	 */
	void enterContainer_declaration(ZigParser.Container_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#container_declaration}.
	 * @param ctx the parse tree
	 */
	void exitContainer_declaration(ZigParser.Container_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#test_decl}.
	 * @param ctx the parse tree
	 */
	void enterTest_decl(ZigParser.Test_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#test_decl}.
	 * @param ctx the parse tree
	 */
	void exitTest_decl(ZigParser.Test_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#comptime_decl}.
	 * @param ctx the parse tree
	 */
	void enterComptime_decl(ZigParser.Comptime_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#comptime_decl}.
	 * @param ctx the parse tree
	 */
	void exitComptime_decl(ZigParser.Comptime_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ZigParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ZigParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#fn_proto}.
	 * @param ctx the parse tree
	 */
	void enterFn_proto(ZigParser.Fn_protoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#fn_proto}.
	 * @param ctx the parse tree
	 */
	void exitFn_proto(ZigParser.Fn_protoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#var_decl_proto}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_proto(ZigParser.Var_decl_protoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#var_decl_proto}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_proto(ZigParser.Var_decl_protoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#global_var_decl}.
	 * @param ctx the parse tree
	 */
	void enterGlobal_var_decl(ZigParser.Global_var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#global_var_decl}.
	 * @param ctx the parse tree
	 */
	void exitGlobal_var_decl(ZigParser.Global_var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#container_field}.
	 * @param ctx the parse tree
	 */
	void enterContainer_field(ZigParser.Container_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#container_field}.
	 * @param ctx the parse tree
	 */
	void exitContainer_field(ZigParser.Container_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ZigParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ZigParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#comptime_statement}.
	 * @param ctx the parse tree
	 */
	void enterComptime_statement(ZigParser.Comptime_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#comptime_statement}.
	 * @param ctx the parse tree
	 */
	void exitComptime_statement(ZigParser.Comptime_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(ZigParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(ZigParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#labeled_statement}.
	 * @param ctx the parse tree
	 */
	void enterLabeled_statement(ZigParser.Labeled_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#labeled_statement}.
	 * @param ctx the parse tree
	 */
	void exitLabeled_statement(ZigParser.Labeled_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(ZigParser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(ZigParser.Loop_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(ZigParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(ZigParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(ZigParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(ZigParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#block_expr_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock_expr_statement(ZigParser.Block_expr_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#block_expr_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock_expr_statement(ZigParser.Block_expr_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#block_expr}.
	 * @param ctx the parse tree
	 */
	void enterBlock_expr(ZigParser.Block_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#block_expr}.
	 * @param ctx the parse tree
	 */
	void exitBlock_expr(ZigParser.Block_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#var_decl_expr_statement}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_expr_statement(ZigParser.Var_decl_expr_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#var_decl_expr_statement}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_expr_statement(ZigParser.Var_decl_expr_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(ZigParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(ZigParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#simple_assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterSimple_assign_expr(ZigParser.Simple_assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#simple_assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitSimple_assign_expr(ZigParser.Simple_assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ZigParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ZigParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#bool_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_or_expr(ZigParser.Bool_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#bool_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_or_expr(ZigParser.Bool_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#bool_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterBool_and_expr(ZigParser.Bool_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#bool_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitBool_and_expr(ZigParser.Bool_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#compare_expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare_expr(ZigParser.Compare_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#compare_expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare_expr(ZigParser.Compare_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#bitwise_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_expr(ZigParser.Bitwise_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#bitwise_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_expr(ZigParser.Bitwise_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#bit_shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterBit_shift_expr(ZigParser.Bit_shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#bit_shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitBit_shift_expr(ZigParser.Bit_shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#addition_expr}.
	 * @param ctx the parse tree
	 */
	void enterAddition_expr(ZigParser.Addition_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#addition_expr}.
	 * @param ctx the parse tree
	 */
	void exitAddition_expr(ZigParser.Addition_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#multiply_expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiply_expr(ZigParser.Multiply_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#multiply_expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiply_expr(ZigParser.Multiply_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#prefix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_expr(ZigParser.Prefix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#prefix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_expr(ZigParser.Prefix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expr(ZigParser.Primary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expr(ZigParser.Primary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(ZigParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(ZigParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ZigParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ZigParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#loop_expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop_expr(ZigParser.Loop_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#loop_expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop_expr(ZigParser.Loop_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#for_expr}.
	 * @param ctx the parse tree
	 */
	void enterFor_expr(ZigParser.For_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#for_expr}.
	 * @param ctx the parse tree
	 */
	void exitFor_expr(ZigParser.For_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#while_expr}.
	 * @param ctx the parse tree
	 */
	void enterWhile_expr(ZigParser.While_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#while_expr}.
	 * @param ctx the parse tree
	 */
	void exitWhile_expr(ZigParser.While_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#curly_suffix_expr}.
	 * @param ctx the parse tree
	 */
	void enterCurly_suffix_expr(ZigParser.Curly_suffix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#curly_suffix_expr}.
	 * @param ctx the parse tree
	 */
	void exitCurly_suffix_expr(ZigParser.Curly_suffix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#init_list}.
	 * @param ctx the parse tree
	 */
	void enterInit_list(ZigParser.Init_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#init_list}.
	 * @param ctx the parse tree
	 */
	void exitInit_list(ZigParser.Init_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#type_expr}.
	 * @param ctx the parse tree
	 */
	void enterType_expr(ZigParser.Type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#type_expr}.
	 * @param ctx the parse tree
	 */
	void exitType_expr(ZigParser.Type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#error_union_expr}.
	 * @param ctx the parse tree
	 */
	void enterError_union_expr(ZigParser.Error_union_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#error_union_expr}.
	 * @param ctx the parse tree
	 */
	void exitError_union_expr(ZigParser.Error_union_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#suffix_expr}.
	 * @param ctx the parse tree
	 */
	void enterSuffix_expr(ZigParser.Suffix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#suffix_expr}.
	 * @param ctx the parse tree
	 */
	void exitSuffix_expr(ZigParser.Suffix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#primary_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_type_expr(ZigParser.Primary_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#primary_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_type_expr(ZigParser.Primary_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#container_decl}.
	 * @param ctx the parse tree
	 */
	void enterContainer_decl(ZigParser.Container_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#container_decl}.
	 * @param ctx the parse tree
	 */
	void exitContainer_decl(ZigParser.Container_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#error_set_decl}.
	 * @param ctx the parse tree
	 */
	void enterError_set_decl(ZigParser.Error_set_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#error_set_decl}.
	 * @param ctx the parse tree
	 */
	void exitError_set_decl(ZigParser.Error_set_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#grouped_expr}.
	 * @param ctx the parse tree
	 */
	void enterGrouped_expr(ZigParser.Grouped_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#grouped_expr}.
	 * @param ctx the parse tree
	 */
	void exitGrouped_expr(ZigParser.Grouped_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#if_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_type_expr(ZigParser.If_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#if_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_type_expr(ZigParser.If_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#labeled_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterLabeled_type_expr(ZigParser.Labeled_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#labeled_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitLabeled_type_expr(ZigParser.Labeled_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#loop_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterLoop_type_expr(ZigParser.Loop_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#loop_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitLoop_type_expr(ZigParser.Loop_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#for_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterFor_type_expr(ZigParser.For_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#for_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitFor_type_expr(ZigParser.For_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#while_type_expr}.
	 * @param ctx the parse tree
	 */
	void enterWhile_type_expr(ZigParser.While_type_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#while_type_expr}.
	 * @param ctx the parse tree
	 */
	void exitWhile_type_expr(ZigParser.While_type_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#switch_expr}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_expr(ZigParser.Switch_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#switch_expr}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_expr(ZigParser.Switch_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_expr}.
	 * @param ctx the parse tree
	 */
	void enterAsm_expr(ZigParser.Asm_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_expr}.
	 * @param ctx the parse tree
	 */
	void exitAsm_expr(ZigParser.Asm_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_output}.
	 * @param ctx the parse tree
	 */
	void enterAsm_output(ZigParser.Asm_outputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_output}.
	 * @param ctx the parse tree
	 */
	void exitAsm_output(ZigParser.Asm_outputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_output_item}.
	 * @param ctx the parse tree
	 */
	void enterAsm_output_item(ZigParser.Asm_output_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_output_item}.
	 * @param ctx the parse tree
	 */
	void exitAsm_output_item(ZigParser.Asm_output_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_input}.
	 * @param ctx the parse tree
	 */
	void enterAsm_input(ZigParser.Asm_inputContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_input}.
	 * @param ctx the parse tree
	 */
	void exitAsm_input(ZigParser.Asm_inputContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_input_item}.
	 * @param ctx the parse tree
	 */
	void enterAsm_input_item(ZigParser.Asm_input_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_input_item}.
	 * @param ctx the parse tree
	 */
	void exitAsm_input_item(ZigParser.Asm_input_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_clobbers}.
	 * @param ctx the parse tree
	 */
	void enterAsm_clobbers(ZigParser.Asm_clobbersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_clobbers}.
	 * @param ctx the parse tree
	 */
	void exitAsm_clobbers(ZigParser.Asm_clobbersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#break_label}.
	 * @param ctx the parse tree
	 */
	void enterBreak_label(ZigParser.Break_labelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#break_label}.
	 * @param ctx the parse tree
	 */
	void exitBreak_label(ZigParser.Break_labelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#block_label}.
	 * @param ctx the parse tree
	 */
	void enterBlock_label(ZigParser.Block_labelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#block_label}.
	 * @param ctx the parse tree
	 */
	void exitBlock_label(ZigParser.Block_labelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#field_init}.
	 * @param ctx the parse tree
	 */
	void enterField_init(ZigParser.Field_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#field_init}.
	 * @param ctx the parse tree
	 */
	void exitField_init(ZigParser.Field_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#while_continue_expr}.
	 * @param ctx the parse tree
	 */
	void enterWhile_continue_expr(ZigParser.While_continue_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#while_continue_expr}.
	 * @param ctx the parse tree
	 */
	void exitWhile_continue_expr(ZigParser.While_continue_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#link_section}.
	 * @param ctx the parse tree
	 */
	void enterLink_section(ZigParser.Link_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#link_section}.
	 * @param ctx the parse tree
	 */
	void exitLink_section(ZigParser.Link_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#addr_space}.
	 * @param ctx the parse tree
	 */
	void enterAddr_space(ZigParser.Addr_spaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#addr_space}.
	 * @param ctx the parse tree
	 */
	void exitAddr_space(ZigParser.Addr_spaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#call_conv}.
	 * @param ctx the parse tree
	 */
	void enterCall_conv(ZigParser.Call_convContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#call_conv}.
	 * @param ctx the parse tree
	 */
	void exitCall_conv(ZigParser.Call_convContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(ZigParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(ZigParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#param_type}.
	 * @param ctx the parse tree
	 */
	void enterParam_type(ZigParser.Param_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#param_type}.
	 * @param ctx the parse tree
	 */
	void exitParam_type(ZigParser.Param_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#if_prefix}.
	 * @param ctx the parse tree
	 */
	void enterIf_prefix(ZigParser.If_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#if_prefix}.
	 * @param ctx the parse tree
	 */
	void exitIf_prefix(ZigParser.If_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#while_prefix}.
	 * @param ctx the parse tree
	 */
	void enterWhile_prefix(ZigParser.While_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#while_prefix}.
	 * @param ctx the parse tree
	 */
	void exitWhile_prefix(ZigParser.While_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#for_prefix}.
	 * @param ctx the parse tree
	 */
	void enterFor_prefix(ZigParser.For_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#for_prefix}.
	 * @param ctx the parse tree
	 */
	void exitFor_prefix(ZigParser.For_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#payload}.
	 * @param ctx the parse tree
	 */
	void enterPayload(ZigParser.PayloadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#payload}.
	 * @param ctx the parse tree
	 */
	void exitPayload(ZigParser.PayloadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#ptr_payload}.
	 * @param ctx the parse tree
	 */
	void enterPtr_payload(ZigParser.Ptr_payloadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#ptr_payload}.
	 * @param ctx the parse tree
	 */
	void exitPtr_payload(ZigParser.Ptr_payloadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#ptr_index_payload}.
	 * @param ctx the parse tree
	 */
	void enterPtr_index_payload(ZigParser.Ptr_index_payloadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#ptr_index_payload}.
	 * @param ctx the parse tree
	 */
	void exitPtr_index_payload(ZigParser.Ptr_index_payloadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#ptr_list_payload}.
	 * @param ctx the parse tree
	 */
	void enterPtr_list_payload(ZigParser.Ptr_list_payloadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#ptr_list_payload}.
	 * @param ctx the parse tree
	 */
	void exitPtr_list_payload(ZigParser.Ptr_list_payloadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#switch_prong}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_prong(ZigParser.Switch_prongContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#switch_prong}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_prong(ZigParser.Switch_prongContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_case(ZigParser.Switch_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_case(ZigParser.Switch_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#switch_item}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_item(ZigParser.Switch_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#switch_item}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_item(ZigParser.Switch_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#for_arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterFor_arguments_list(ZigParser.For_arguments_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#for_arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitFor_arguments_list(ZigParser.For_arguments_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#for_item}.
	 * @param ctx the parse tree
	 */
	void enterFor_item(ZigParser.For_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#for_item}.
	 * @param ctx the parse tree
	 */
	void exitFor_item(ZigParser.For_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(ZigParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(ZigParser.Assign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#compare_op}.
	 * @param ctx the parse tree
	 */
	void enterCompare_op(ZigParser.Compare_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#compare_op}.
	 * @param ctx the parse tree
	 */
	void exitCompare_op(ZigParser.Compare_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#bitwise_op}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_op(ZigParser.Bitwise_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#bitwise_op}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_op(ZigParser.Bitwise_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#bit_shift_op}.
	 * @param ctx the parse tree
	 */
	void enterBit_shift_op(ZigParser.Bit_shift_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#bit_shift_op}.
	 * @param ctx the parse tree
	 */
	void exitBit_shift_op(ZigParser.Bit_shift_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#addition_op}.
	 * @param ctx the parse tree
	 */
	void enterAddition_op(ZigParser.Addition_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#addition_op}.
	 * @param ctx the parse tree
	 */
	void exitAddition_op(ZigParser.Addition_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#multiply_op}.
	 * @param ctx the parse tree
	 */
	void enterMultiply_op(ZigParser.Multiply_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#multiply_op}.
	 * @param ctx the parse tree
	 */
	void exitMultiply_op(ZigParser.Multiply_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#prefix_op}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_op(ZigParser.Prefix_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#prefix_op}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_op(ZigParser.Prefix_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#prefix_type_op}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_type_op(ZigParser.Prefix_type_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#prefix_type_op}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_type_op(ZigParser.Prefix_type_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#suffix_op}.
	 * @param ctx the parse tree
	 */
	void enterSuffix_op(ZigParser.Suffix_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#suffix_op}.
	 * @param ctx the parse tree
	 */
	void exitSuffix_op(ZigParser.Suffix_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#fn_call_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFn_call_arguments(ZigParser.Fn_call_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#fn_call_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFn_call_arguments(ZigParser.Fn_call_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#slice_type_start}.
	 * @param ctx the parse tree
	 */
	void enterSlice_type_start(ZigParser.Slice_type_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#slice_type_start}.
	 * @param ctx the parse tree
	 */
	void exitSlice_type_start(ZigParser.Slice_type_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#ptr_type_start}.
	 * @param ctx the parse tree
	 */
	void enterPtr_type_start(ZigParser.Ptr_type_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#ptr_type_start}.
	 * @param ctx the parse tree
	 */
	void exitPtr_type_start(ZigParser.Ptr_type_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#array_type_start}.
	 * @param ctx the parse tree
	 */
	void enterArray_type_start(ZigParser.Array_type_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#array_type_start}.
	 * @param ctx the parse tree
	 */
	void exitArray_type_start(ZigParser.Array_type_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#container_decl_auto}.
	 * @param ctx the parse tree
	 */
	void enterContainer_decl_auto(ZigParser.Container_decl_autoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#container_decl_auto}.
	 * @param ctx the parse tree
	 */
	void exitContainer_decl_auto(ZigParser.Container_decl_autoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#container_decl_type}.
	 * @param ctx the parse tree
	 */
	void enterContainer_decl_type(ZigParser.Container_decl_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#container_decl_type}.
	 * @param ctx the parse tree
	 */
	void exitContainer_decl_type(ZigParser.Container_decl_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#byte_align}.
	 * @param ctx the parse tree
	 */
	void enterByte_align(ZigParser.Byte_alignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#byte_align}.
	 * @param ctx the parse tree
	 */
	void exitByte_align(ZigParser.Byte_alignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_list(ZigParser.Identifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_list(ZigParser.Identifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#switch_prong_list}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_prong_list(ZigParser.Switch_prong_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#switch_prong_list}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_prong_list(ZigParser.Switch_prong_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_output_list}.
	 * @param ctx the parse tree
	 */
	void enterAsm_output_list(ZigParser.Asm_output_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_output_list}.
	 * @param ctx the parse tree
	 */
	void exitAsm_output_list(ZigParser.Asm_output_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#asm_input_list}.
	 * @param ctx the parse tree
	 */
	void enterAsm_input_list(ZigParser.Asm_input_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#asm_input_list}.
	 * @param ctx the parse tree
	 */
	void exitAsm_input_list(ZigParser.Asm_input_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(ZigParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(ZigParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZigParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(ZigParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZigParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(ZigParser.Expr_listContext ctx);
}
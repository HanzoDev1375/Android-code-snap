// Generated from /storage/emulated/0/cdm/ZigParser.g4 by ANTLR 4.13.2
package ir.ninjacoder.codesnap.antlr4.zig;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZigParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZigParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZigParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(ZigParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#container_members}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer_members(ZigParser.Container_membersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#container_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer_declaration(ZigParser.Container_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#test_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest_decl(ZigParser.Test_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#comptime_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComptime_decl(ZigParser.Comptime_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(ZigParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#fn_proto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_proto(ZigParser.Fn_protoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#var_decl_proto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl_proto(ZigParser.Var_decl_protoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#global_var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal_var_decl(ZigParser.Global_var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#container_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer_field(ZigParser.Container_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ZigParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#comptime_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComptime_statement(ZigParser.Comptime_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(ZigParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#labeled_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeled_statement(ZigParser.Labeled_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#loop_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_statement(ZigParser.Loop_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(ZigParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(ZigParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#block_expr_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_expr_statement(ZigParser.Block_expr_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#block_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_expr(ZigParser.Block_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#var_decl_expr_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl_expr_statement(ZigParser.Var_decl_expr_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#assign_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_expr(ZigParser.Assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#simple_assign_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_assign_expr(ZigParser.Simple_assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ZigParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#bool_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_or_expr(ZigParser.Bool_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#bool_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_and_expr(ZigParser.Bool_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#compare_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_expr(ZigParser.Compare_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#bitwise_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_expr(ZigParser.Bitwise_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#bit_shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBit_shift_expr(ZigParser.Bit_shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#addition_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition_expr(ZigParser.Addition_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#multiply_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply_expr(ZigParser.Multiply_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#prefix_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_expr(ZigParser.Prefix_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expr(ZigParser.Primary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#if_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(ZigParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ZigParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#loop_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_expr(ZigParser.Loop_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#for_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_expr(ZigParser.For_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#while_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_expr(ZigParser.While_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#curly_suffix_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurly_suffix_expr(ZigParser.Curly_suffix_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#init_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_list(ZigParser.Init_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_expr(ZigParser.Type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#error_union_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError_union_expr(ZigParser.Error_union_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#suffix_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix_expr(ZigParser.Suffix_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#primary_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_type_expr(ZigParser.Primary_type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#container_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer_decl(ZigParser.Container_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#error_set_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError_set_decl(ZigParser.Error_set_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#grouped_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrouped_expr(ZigParser.Grouped_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#if_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_type_expr(ZigParser.If_type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#labeled_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeled_type_expr(ZigParser.Labeled_type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#loop_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop_type_expr(ZigParser.Loop_type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#for_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_type_expr(ZigParser.For_type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#while_type_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_type_expr(ZigParser.While_type_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#switch_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_expr(ZigParser.Switch_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_expr(ZigParser.Asm_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_output(ZigParser.Asm_outputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_output_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_output_item(ZigParser.Asm_output_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_input(ZigParser.Asm_inputContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_input_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_input_item(ZigParser.Asm_input_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_clobbers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_clobbers(ZigParser.Asm_clobbersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#break_label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_label(ZigParser.Break_labelContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#block_label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_label(ZigParser.Block_labelContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#field_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_init(ZigParser.Field_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#while_continue_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_continue_expr(ZigParser.While_continue_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#link_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink_section(ZigParser.Link_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#addr_space}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddr_space(ZigParser.Addr_spaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#call_conv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_conv(ZigParser.Call_convContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#param_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_decl(ZigParser.Param_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#param_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_type(ZigParser.Param_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#if_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_prefix(ZigParser.If_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#while_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_prefix(ZigParser.While_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#for_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_prefix(ZigParser.For_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#payload}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPayload(ZigParser.PayloadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#ptr_payload}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPtr_payload(ZigParser.Ptr_payloadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#ptr_index_payload}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPtr_index_payload(ZigParser.Ptr_index_payloadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#ptr_list_payload}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPtr_list_payload(ZigParser.Ptr_list_payloadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#switch_prong}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_prong(ZigParser.Switch_prongContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#switch_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_case(ZigParser.Switch_caseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#switch_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_item(ZigParser.Switch_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#for_arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_arguments_list(ZigParser.For_arguments_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#for_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_item(ZigParser.For_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#assign_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_op(ZigParser.Assign_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#compare_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_op(ZigParser.Compare_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#bitwise_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_op(ZigParser.Bitwise_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#bit_shift_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBit_shift_op(ZigParser.Bit_shift_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#addition_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition_op(ZigParser.Addition_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#multiply_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiply_op(ZigParser.Multiply_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#prefix_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_op(ZigParser.Prefix_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#prefix_type_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_type_op(ZigParser.Prefix_type_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#suffix_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix_op(ZigParser.Suffix_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#fn_call_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFn_call_arguments(ZigParser.Fn_call_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#slice_type_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice_type_start(ZigParser.Slice_type_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#ptr_type_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPtr_type_start(ZigParser.Ptr_type_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#array_type_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type_start(ZigParser.Array_type_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#container_decl_auto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer_decl_auto(ZigParser.Container_decl_autoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#container_decl_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainer_decl_type(ZigParser.Container_decl_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#byte_align}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitByte_align(ZigParser.Byte_alignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#identifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_list(ZigParser.Identifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#switch_prong_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_prong_list(ZigParser.Switch_prong_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_output_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_output_list(ZigParser.Asm_output_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#asm_input_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_input_list(ZigParser.Asm_input_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#param_decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_decl_list(ZigParser.Param_decl_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZigParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_list(ZigParser.Expr_listContext ctx);
}